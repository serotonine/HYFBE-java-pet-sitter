package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.employee.EmployeeCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeUpdateDTO;
import com.hyfbe.pet_sitter.enums.Role;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.EmployeeMapper;
import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;
    private final UserService uService;
    private final PasswordEncoder encoder;

    // GET
    @Transactional(readOnly = true)
    public  List<EmployeeCompleteResponseDTO> getAllEmployees(){
        List<Employee> employees = repo.findAll();
        return employees.stream().map(mapper::toCompleteResponseDTO).collect(Collectors.toList());
    }

    // CREATE
    @Transactional
    public EmployeeCompleteResponseDTO addEmployee(String name, String address, String tel, String email ){

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

        return mapper.toCompleteResponseDTO(saved);
    }

    // PATCH
    @Transactional
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeUpdateDTO dto){
        Employee employee = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Employee", id));
        String name = dto.getName();
        String email = dto.getEmail();
        String address = dto.getAddress();
        String tel = dto.getTel();
        if(name !=null){
            employee.setName(name);
        }
        if(email !=null){
            employee.setEmail(email);
        }
        if(address !=null){
            employee.setAddress(address);
        }
        if(tel !=null){
            employee.setTel(tel);
        }
        repo.save(employee);
        return mapper.toResponseDTO(employee);
    }

    // DELETE
    @Transactional
    public EmployeeResponseDTO deleteEmployee(Long id){
        Employee employee = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Employee", id));
        EmployeeResponseDTO dto = mapper.toResponseDTO(employee);
        repo.delete(employee);
        return  dto;
    }
}
