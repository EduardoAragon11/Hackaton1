/*package com.example.hackaton.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.hackaton.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("secret")
    private String secret;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;


    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * 60 * 60 * 24);

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("role", userDetails.getAuthorities().toArray()[0].toString())
                .withExpiresAt(expiration)
                .sign(algorithm);
    }

    public void validateToken(String token, String email) throws AuthenticationException {
        JWT.require(Algorithm.HMAC256(secret)).build().verify(token);

        UserDetails userDetails = userService.userDetailsService().loadUserByUsername(email);
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, token, userDetails.getAuthorities());
        securityContext.setAuthentication(authenticationToken);
        SecurityContextHolder.setContext(securityContext);

    }

    public String extractUsername(String token) {
        return JWT.decode(token).getSubject();
    }

    public String extractClaim(String token, String claim) {
        return JWT.decode(token).getClaim(claim).asString();
    }
}
*/