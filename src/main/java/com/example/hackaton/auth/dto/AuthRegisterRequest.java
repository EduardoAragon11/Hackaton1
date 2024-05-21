package com.example.hackaton.auth.dto;

import lombok.Data;

@Data
public class AuthRegisterRequest {
    private String username;
    private String password;
    private Boolean IsUser;
}
