package com.AAAA.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class DaoService {
    private static int usersCount=0;
       private static List<User>users=new ArrayList<>();
       static {
           users.add(new User(++usersCount,"abdo",LocalDate.now()));
           users.add(new User(++usersCount,"abdo1",LocalDate.now()));
       }
       public  List<User>findAll(){
           return users;
       }

    public  User findUser(int id){
        Predicate<? super User>predicate=user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);


    }
    public void deleteUser(int id){
        Predicate<? super User>predicate=user -> user.getId().equals(id);
        users.removeIf(predicate);

    }
    public User save(User user){
           user.setId(++usersCount);
            users.add(user);
            return user;
    }

}
