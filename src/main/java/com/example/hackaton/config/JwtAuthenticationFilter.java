package com.example.hackaton.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JwtService jwtService;

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                             HttpServletResponse response,
                                             FilterChain filterChain)
            throws ServletException, IOException{
        String authHeader = request.getHeader("Authorization");
        String jwtToken;
        String username;
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            doFilter(request, response, filterChain);
            return;
        }
        jwtToken = authHeader.substring(7);
        username = jwtService.extractUsername(jwtToken);
        if(username != null) {
            jwtService.validateToken(jwtToken, username);
        }
        filterChain.doFilter(request, response);
    }
}
