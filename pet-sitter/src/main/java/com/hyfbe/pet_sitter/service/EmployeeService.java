package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.exception.EntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.EmployeeMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository repo;
    EmployeeMapper mapper;
    public EmployeeService(EmployeeRepository repo, EmployeeMapper mapper ) {
        this.repo = repo;
        this.mapper = mapper;
    }
    // GET
    public  ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(repo.findAll());
    }

    // CREATE
    public ResponseEntity<?> addEmployee(String name, String address, String tel, String email){
        Employee employee = new Employee(name);

        if(address != null){
            employee.setAddress(address);
        }
        if(tel != null){
            employee.setTel(tel);
        }
        if(email != null){
            employee.setEmail(email);
        }
        repo.save(employee);
        return ResponseEntity.ok().body(employee);
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
