package com.example.hackaton.auth.application;

import com.example.hackaton.auth.domain.AuthService;
import com.example.hackaton.auth.dto.AuthJwtResponse;
import com.example.hackaton.auth.dto.AuthLoginRequest;
import com.example.hackaton.auth.dto.AuthRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    ResponseEntity<AuthJwtResponse> register(AuthRegisterRequest req) {
        AuthJwtResponse token = authService.request(req);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    ResponseEntity<AuthJwtResponse> login(AuthLoginRequest req) {
        AuthJwtResponse token = authService.login(req);
        return ResponseEntity.ok(token);
    }


}
