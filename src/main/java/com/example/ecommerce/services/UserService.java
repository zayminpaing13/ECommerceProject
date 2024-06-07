package com.example.ecommerce.services;

import com.example.ecommerce.model.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> findUserByEmail(String email);
    public User createUser(User user);
}
