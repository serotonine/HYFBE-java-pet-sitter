package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.enums.Role;
import com.hyfbe.pet_sitter.exception.EntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.EmployeeMapper;
import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    EmployeeRepository repo;
    EmployeeMapper mapper;
    UserService uService;
    PasswordEncoder encoder;
    public EmployeeService(EmployeeRepository repo, EmployeeMapper mapper, UserService uService, PasswordEncoder encoder ) {
        this.repo = repo;
        this.mapper = mapper;
        this.uService = uService;
        this.encoder = encoder;
    }
    // GET
    public  ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(repo.findAll());
    }

    // CREATE
    @Transactional
    public ResponseEntity<?> addEmployee(String name, String address, String tel, String email ){

        // Employee side.
        Employee employee = new Employee(name, email);

        if(address != null){
            employee.setAddress(address);
        }
        if(tel != null){
            employee.setTel(tel);
        }

        // User side.
        String pwd = UUID.randomUUID().toString().substring(0, 10);
        User user = new User(email, encoder.encode(pwd));
        user.setRole(Role.EMPLOYEE);

        // link user on employee side.
        employee.setUser(user);
        // Save employee and retrieve its id.
        Employee saved = repo.save(employee);
        // link employee on user side.
        user.setEmployee(saved);

        return ResponseEntity.ok().body(saved);
    }

    // DELETE
    @Transactional
    public ResponseEntity<?> deleteEmployee(Long id){
        Employee employee = repo.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee", id));
        // TODO Check why the output set null.
        EmployeeResponseDTO dto = mapper.toResponseDTO(employee);
        System.out.println("Employee DTO : " + dto.getName() + " " + dto.getId());
        repo.delete(employee);
        repo.flush();
        return ResponseEntity.ok("Employee removed : " + dto);
    }
}
