package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository emrepo;
    public EmployeeService(EmployeeRepository emrepo) {
        this.emrepo = emrepo;
    }
    // GET
    public  ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(emrepo.findAll());
    }

    // CREATE
    public ResponseEntity<?> add(String name, String address, String tel, String email){
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
        emrepo.save(employee);
        return ResponseEntity.ok().body(employee);
    }
}
