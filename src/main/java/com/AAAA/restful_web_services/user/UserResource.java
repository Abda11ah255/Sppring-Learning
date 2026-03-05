package com.AAAA.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class UserResource {

    private DaoService service;
    @Autowired
    public UserResource(DaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/getUsers")
    public List<User> retrieveAllUsers(){
   return service.findAll();
    }
    @GetMapping(path = "/getUsers/{id}")
    public EntityModel <User> retrieveSingleUsers(@PathVariable int id){
        User user =service.findUser(id);
        if (user==null)
        throw new UserNotFoundException("id:"+id);
        EntityModel<User> entityModel=EntityModel.of(user);
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @DeleteMapping(path = "/deleteUser/{id}")
    public void deleteUser(@PathVariable int id){
        User user =service.findUser(id);
        if (user==null)
            throw new UserNotFoundException("id:"+id);
        else {
    service.deleteUser(id);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
