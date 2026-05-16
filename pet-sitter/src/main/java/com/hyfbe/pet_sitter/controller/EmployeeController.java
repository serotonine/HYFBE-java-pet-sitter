package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.employee.EmployeeCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeUpdateDTO;
import com.hyfbe.pet_sitter.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    // CONSTRUCTOR
    public EmployeeController(EmployeeService service) {

        this.service = service;
    }
    // GET
    @GetMapping
    public ResponseEntity<List<EmployeeCompleteResponseDTO>>getAllEmployees(){

        List<EmployeeCompleteResponseDTO> employees = service.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    // ADD
    @PostMapping
    public ResponseEntity<EmployeeCompleteResponseDTO> addEmployee(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String tel
    ) {
        // TODO EmployeeRequest
        EmployeeCompleteResponseDTO created = service.addEmployee(name, address, tel, email);
        return ResponseEntity.created(URI.create("/api/v1/employee/" + created.getId())).body(created);
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeUpdateDTO dto
            ){
        EmployeeResponseDTO updated = service.updateEmployee(id, dto);
        return ResponseEntity.ok().body(updated);

    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> deleteEmployee(
            @PathVariable Long id
    ){
        EmployeeResponseDTO deleted = service.deleteEmployee(id);
        return ResponseEntity.ok().body(deleted);
    }
}
