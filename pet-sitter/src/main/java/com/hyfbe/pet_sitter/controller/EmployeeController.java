package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.service.CustomerService;
import com.hyfbe.pet_sitter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // CONSTRUCTOR
    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }
    // GET
    @GetMapping("")
    public ResponseEntity<?>getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // ADD
    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(
            @RequestParam String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String tel,
            @RequestParam(required = false) String email
    ) {
        return employeeService.add(name, address, tel, email);
    }
}
