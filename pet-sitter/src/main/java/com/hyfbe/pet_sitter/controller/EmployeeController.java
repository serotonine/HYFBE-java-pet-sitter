package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    // CONSTRUCTOR
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    // GET
    @GetMapping("")
    public ResponseEntity<?>getAllEmployees(){
        return service.getAllEmployees();
    }

    // ADD
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String tel
    ) {
        return service.addEmployee(name, address, tel, email);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(
            @PathVariable Long id
    ){
        return service.deleteEmployee(id);
    }
}
