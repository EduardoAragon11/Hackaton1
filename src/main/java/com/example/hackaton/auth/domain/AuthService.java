package com.example.hackaton.auth.domain;

import com.example.hackaton.auth.dto.AuthJwtResponse;
import com.example.hackaton.auth.dto.AuthLoginRequest;
import com.example.hackaton.auth.dto.AuthRegisterRequest;
import com.example.hackaton.config.JwtService;
import com.example.hackaton.exceptions.UsernameAlreadyExists;
import com.example.hackaton.user.domain.Role;
import com.example.hackaton.user.domain.User;
import com.example.hackaton.user.infrastucture.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    public AuthJwtResponse login(AuthLoginRequest authLoginRequest){
        User user = userRepository.findByEmail(authLoginRequest.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException ("not found user"));
        passwordEncoder.matches(authLoginRequest.getPassword(), user.getPassword());
        AuthJwtResponse authJwtResponse = new AuthJwtResponse();
        authJwtResponse.setToken(jwtService.generateToken(user));
        return authJwtResponse;
    }

    public AuthJwtResponse request(AuthRegisterRequest authRegisterRequest){
        Optional<User> user = userRepository.findByEmail(authRegisterRequest.getUsername());

        if(user.isPresent()){
            throw new UsernameAlreadyExists("user already exists");
        }

        User newUser = new User();
        newUser.setEmail(authRegisterRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(authRegisterRequest.getPassword()));
        //modelMApper!!!!!!!!!!


        userRepository.save(newUser);
        AuthJwtResponse authJwtResponse = new AuthJwtResponse();
        authJwtResponse.setToken(jwtService.generateToken(newUser));
        return authJwtResponse;
    }
}
