package com.example.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRes {
    private String email;
    private String token;
    private String firstName;
    private String lastName;

    public LoginRes(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
