package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    public PetController(){}

    // GET
    @GetMapping("")
    public ResponseEntity<?> getAllCustomers(){
        return petService.getAllPets();
    }

    // ADD
    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(
            @RequestParam String name,
            @RequestParam Long customer,
            @RequestParam(required = false) Long type,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) byte[] comment

    ) {
        return petService.add(name, customer, type, age, comment);
    }
}
