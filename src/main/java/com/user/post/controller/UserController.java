package com.user.post.controller;


import com.user.post.model.User;
import com.user.post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService service;

    /*

     */
    public List<User> getUsers() {

        List<User> users = service.getUsers();

        System.out.println("No of users: "+users.size());

        // users.forEach(System.out::println);
        users.forEach(user -> { System.out.println(user); });

        return users;

    }

    /*

     */
    public String postUserObject(User user) {

        System.out.println("Incoming object: "+user);

        String response = service.postUserObject(user);

        return response;

    }

}
