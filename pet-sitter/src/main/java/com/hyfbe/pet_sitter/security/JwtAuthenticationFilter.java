package com.hyfbe.pet_sitter.security;

import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.repository.UserRepository;
import com.hyfbe.pet_sitter.security.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter  // ← change this
{
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtUtils jwtUtils, UserRepository userRepository) {
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            log.warn("Token: {}", jwtUtils.getSubject(token));
            log.warn("header: {}", request.getHeader("Authorization"));
            log.warn("valid: {}", header != null && jwtUtils.isValid(header.substring(7)));


            if (jwtUtils.isValid(token)) {
                String name = jwtUtils.getSubject(token);
                User user = userRepository.findByName(name).orElse(null);

                if (user != null) {
                    var authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().name());
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    List.of(authority)
                            );
                    SecurityContextHolder.getContext().setAuthentication(auth);

                }
            }
        }

        chain.doFilter(request, response);  // ← pass response too
    }
}
