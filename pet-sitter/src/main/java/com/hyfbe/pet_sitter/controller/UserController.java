package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.dto.user.LoginResponseDTO;
import com.hyfbe.pet_sitter.dto.user.UserRequestDTO;
import com.hyfbe.pet_sitter.dto.user.UserResponseDTO;
import com.hyfbe.pet_sitter.repository.UserRepository;
import com.hyfbe.pet_sitter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service, UserRepository repo) {

        this.service = service;
    }
// GET
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = service.getAllUsers();
        return ResponseEntity.ok().body(users);
    }
/** Loggin **/
@PostMapping("/login")
public ResponseEntity login(
        @RequestParam String email,
        @RequestParam String pwd
) {
   LoginResponseDTO response = service.login(email, pwd);
    return ResponseEntity.ok(response);
}
// POST
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> addUser( @Valid @RequestBody CustomerRequestDTO customerDTO) {

        UserResponseDTO created =  service.addUser(customerDTO);
        return ResponseEntity.created(URI.create("/api/v1/user/" + created.getId())).body(created);

    }
}
