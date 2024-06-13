package com.example.ecommerce.controllers;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repositories.UserRepository;
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
    private UserRepository userRepository;

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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User updated_user = userService.getUserById(id);
        updated_user.setEmail(user.getEmail());
        updated_user.setPassword(user.getPassword());
        updated_user.setRole(user.getRole());
        updated_user.setRole(user.getFirstName());
        updated_user.setLastName(user.getLastName());
        userRepository.save(updated_user);
        return updated_user;
    }
}
