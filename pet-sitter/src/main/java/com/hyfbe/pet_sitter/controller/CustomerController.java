package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    // CONSTRUCTOR
    public CustomerController(CustomerService service) {
        this.customerService = service;
    }
    // GET
    @GetMapping("")
    public ResponseEntity<?>getAllCustomers(){
        return customerService.getAllCustomers();
    }

    // ADD
    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(
            @RequestParam String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String tel,
            @RequestParam(required = false) String email
    ) {
        return customerService.add(name, address, tel, email);
    }
    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable Long id
    ){
        return customerService.deleteUser(id);
    }
}
