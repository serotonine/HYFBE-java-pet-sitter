package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository crepo;

    public CustomerService(CustomerRepository repo) {
        this.crepo = repo;

    }
    // GET
    public  ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok().body(crepo.findAll());
    }

    // CREATE
    public ResponseEntity<?> add(String name, String address, String tel, String email){
        Customer customer = new Customer(name);

        if(address != null){
            customer.setAddress(address);
        }
        if(tel != null){
            customer.setTel(tel);
        }
        if(email != null){
            customer.setEmail(email);
        }
        crepo.save(customer);
        return ResponseEntity.ok().body(customer);
    }
}
