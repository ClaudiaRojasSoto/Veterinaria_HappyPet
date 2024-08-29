package com.veterinaria.security;


import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.crypto.KeyGenerator;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.crypto.SecretKey;

import com.veterinaria.entity.User;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationMs;

    private SecretKey key;

    @PostConstruct
    public void init() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA512");
            key = keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm available for key generation", e);
        }
    }

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
    public String getUserEmailFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();  // Devuelve el email
    }
}
