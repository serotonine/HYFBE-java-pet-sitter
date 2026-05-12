package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.dto.user.UserRequestDTO;
import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();

    }

    @PostMapping
    public User addUser( @Valid @RequestBody CustomerRequestDTO customerDTO) {
        return service.addUser(customerDTO);
    }
}
