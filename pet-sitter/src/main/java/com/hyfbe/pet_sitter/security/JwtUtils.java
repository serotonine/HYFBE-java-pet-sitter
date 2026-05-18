package com.hyfbe.pet_sitter.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils
{
    private final Key key;          // The signing key used to create/validate JWTs
    private final long expiration; // JWT expiration duration in milliseconds
    private final long refreshExpiration;

    public JwtUtils(
            @Value("${app.jwt.secret}") String secret, // Base64 encoded secret from properties
            @Value("${app.jwt.expiration}") long expiration, // Expiration time from properties
            @Value("${app.jwt.refresh-expiration}") long refreshExpiration
    )
    {
        // Decode Base64 string → raw bytes → secure HMAC SHA256 key
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.expiration = expiration;
        this.refreshExpiration = refreshExpiration;
    }

    public String generateToken(String subject, Map<String, Object> claims)
    {
        Date now = new Date();                             // Current time
        Date exp = new Date(now.getTime() + expiration);   // Expiration timestamp

        return Jwts.builder()
                .setClaims(claims)                         // Add extra claims (role, userId)
                .setSubject(subject)                       // The "sub" field (usually email)
                .setIssuedAt(now)                          // Token creation time
                .setExpiration(exp)                        // Token expiration time
                .signWith(key, SignatureAlgorithm.HS256)   // Sign the token with our secure key
                .compact();                                // Convert to final JWT string
    }

    public boolean isValid(String token)
    {
        try
        {
            // Check token expiration by parsing the JWT
            Date expiration = parse(token).getBody().getExpiration();
            return expiration.after(new Date());           // Valid if expiration > now
        }
        catch (JwtException | IllegalArgumentException e)  // Invalid signature, malformed token, expired, etc.
        {
            return false;
        }
    }

    public String getSubject(String token)
    {
        // Returns the "sub" claim (email)
        return parse(token).getBody().getSubject();
    }

    private Jws<Claims> parse(String token)
    {
        // Build a parser that uses our signing key
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);                    // Parses and validates the JWT
    }
}
