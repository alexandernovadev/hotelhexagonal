package com.hotels.mart.infrastructure.config;

import io.jsonwebtoken.*;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private String secret = "secretKey";

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
      // log exception
    }
    return false;
  }

  public String extractUsername(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }

  public Date extractExpiration(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
}
