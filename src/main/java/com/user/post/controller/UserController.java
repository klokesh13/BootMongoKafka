package com.user.post.controller;


import com.user.post.model.User;
import com.user.post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Controller
public class UserController {


    /** The service. */
    @Autowired
    UserService service;

    
    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<User> getUsers() {

        List<User> users = service.getUsers();

        System.out.println("No of users: "+users.size());

        // users.forEach(System.out::println);
        users.forEach(user -> { System.out.println(user); });

        return users;

    }

    
    /**
     * Post user object.
     *
     * @param user the user
     * @return the string
     */
    public String postUserObject(User user) {

        System.out.println("Incoming object: "+user);

        String response = service.postUserObject(user);

        return response;

    }

}
