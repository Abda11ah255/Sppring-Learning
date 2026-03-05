package com.AAAA.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonSbiController {
//    @GetMapping(value = "/{version}/personsbi",version = "1.0.0")
//    public PersonV1 getFirstVersionOfPerson(){
//        return new PersonV1("nnn aaa");
//    }
//    @GetMapping(value = "/{version}/personsbi",version = "2.0.0")
//    public PersonV2 getSecondVersionOfPerson(){
//        return new PersonV2(new Name("bob","marlyyyyyyyyy"));
//    }

//    @GetMapping(path = "/personsbi", version="1.0.0")
//    public PersonV1 getFirstVersionOfPersonRequestParameter (){
//        return new PersonV1("nnn aaa");
//    }
//
//    @GetMapping(path = "/personsbi",version="2.0.0")
//    public PersonV2 getSecondVersionOfPersonRequestParameter (){
//        return new PersonV2(new Name("nnn ","aaaa"));
//    }
//
//    @GetMapping(path = "/personsbi/header",headers = "X-API-VERSION=1")
//    public PersonV1 getFirstVersionOfPersonRequestHeader (){
//        return new PersonV1("salsa");
//    }
    // Media Type Versioning - Version 1
    @GetMapping( path = "/personsbi",
            produces = "application/vnd.company.app-v1+json"
    )
    public PersonV1 getPersonV1MediaType(){
        return new PersonV1("nnn aaa");
    }

    // Media Type Versioning - Version 2
    @GetMapping( path = "/personsbi",
            produces = "application/vnd.company.app-v2+json"
    )
    public PersonV2 getPersonV2MediaType(){
        return new PersonV2(
                new Name("bob","marly")
        );
    }
}
