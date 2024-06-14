package com.example.ecommerce.controllers;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.dto.UserUpdate;
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

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserUpdate userUpdate){
        User updated_user = userService.getUserById(id);
        if(userUpdate.getEmail()!=null){
            updated_user.setEmail(userUpdate.getEmail());
        }
        if(userUpdate.getPassword()!=null){
            updated_user.setPassword(userUpdate.getPassword());
        }
        if(userUpdate.getRole()!=null){
            updated_user.setRole(userUpdate.getRole());
        }
        if(userUpdate.getFirstName()!=null){
            updated_user.setFirstName(userUpdate.getFirstName());
        }
        if(userUpdate.getLastName()!=null){
            updated_user.setLastName(userUpdate.getLastName());
        }
        userRepository.save(updated_user);
        return updated_user;
    }
}
