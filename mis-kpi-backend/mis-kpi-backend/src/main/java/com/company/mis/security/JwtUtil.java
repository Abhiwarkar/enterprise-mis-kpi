package com.company.mis.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        // JWT logic later
        return "dummy-jwt-token-for-" + username;
    }

    public boolean validateToken(String token) {
        return token.startsWith("dummy");
    }
}
