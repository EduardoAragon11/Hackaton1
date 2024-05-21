package com.example.hackaton.auth.dto;

import lombok.Data;

@Data
public class AuthLoginRequest {
    private String username;
    private String password;
}
