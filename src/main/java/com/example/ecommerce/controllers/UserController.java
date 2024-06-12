package com.example.ecommerce.controllers;

import com.example.ecommerce.model.User;
import com.example.ecommerce.services.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
@JsonIgnoreProperties
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public User signup(@RequestBody User user)  {
            return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
