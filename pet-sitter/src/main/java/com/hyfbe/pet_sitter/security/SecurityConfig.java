package com.hyfbe.pet_sitter.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }



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
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
                        // USER
                        .requestMatchers(HttpMethod.POST, "/api/v1/user/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/user/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/user/**").hasRole("ADMIN")
                        // CUSTOMER
                        .requestMatchers(HttpMethod.GET, "/api/v1/customer").hasAnyRole("ADMIN","EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/customer/**").hasAnyRole("ADMIN","CUSTOMER")
                        .requestMatchers(HttpMethod.PATCH, "/api/v1/customer/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/customer/**").hasRole("CUSTOMER")
                        // PET
                        .requestMatchers(HttpMethod.GET, "/api/v1/pet/").hasAnyRole("ADMIN","EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/pet/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PATCH, "/api/v1/pet/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/pet/**").hasRole("CUSTOMER")
                        // Pet Enrolment
                        .requestMatchers(HttpMethod.GET, "/api/v1/pet/enrolment").hasAnyRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PATCH, "/api/v1/pet/enrolment").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/pet/enrolment").hasRole("CUSTOMER")
                        // PET TYPE
                        .requestMatchers(HttpMethod.GET, "/api/v1/pet-type").permitAll()

                        // EMPLOYEE
                        // ACTIVITY
                        .requestMatchers(HttpMethod.GET, "/api/v1/activity/**").permitAll()

                        // ADMIN can do everything else
                        .anyRequest().hasRole("ADMIN")
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, e) -> {
                            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.getWriter().write("""
                                {"status":401,"error":"Unauthorized","path":"%s"}
                                """.formatted(request.getRequestURI()));
                        })
                        .accessDeniedHandler((request, response, e) -> {
                            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            response.getWriter().write("""
                                {"status":403,"error":"Forbidden","path":"%s"}
                                """.formatted(request.getRequestURI()));
                        })
                )
                // Run JWT filter before default UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // Finalizes and returns the configured SecurityFilterChain.
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:3000", "https://java-angular-pet-sitter.netlify.app", "https://serotonine.alwaysdata.net"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }

    /**
     * `BCryptPasswordEncoder` is part of Spring Security — no extra library needed beyond.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
