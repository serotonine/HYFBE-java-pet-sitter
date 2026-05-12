package com.hyfbe.pet_sitter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // csrf.disable() because:
        // - You're building a REST API
        // - CSRF protection is mainly needed for browser form submissions
        // - With JWT tokens or stateless APIs → CSRF is not needed
        // ⚠️ don't disable in a stateful web app with sessions!
        // anyRequest()  → applies to ALL endpoints
        // permitAll()   → everyone can access, no authentication needed

        // It's the "disable auth for now" comment — temporary for development
        // In production you'd have something like:

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
             /*           .requestMatchers(HttpMethod.GET,"/api/user/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/auth/loggin").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/user/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/api/user/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/user/**").hasRole("ADMIN")*/
                        .anyRequest().permitAll()
                );
                // Run JWT filter before default UsernamePasswordAuthenticationFilter
                // .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
        // Finalizes and returns the configured SecurityFilterChain.
        return http.build();
    }

    /**
     * `BCryptPasswordEncoder` is part of Spring Security — no extra library needed beyond:
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
