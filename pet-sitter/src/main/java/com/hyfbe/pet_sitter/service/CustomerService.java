package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.exception.EntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.CustomerMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository crepo;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repo, CustomerMapper mapper) {
        this.crepo = repo;
        this.mapper = mapper;
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

    // DELETE
    @Transactional
    public ResponseEntity<?> deleteUser(Long id){
        Customer customer = crepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer", id));
        // Manually delete pets items
        List<Pet> pets = new ArrayList<>(customer.getPets());
        for(Pet pet : pets){
            customer.removePet(pet);
        }
        CustomerResponseDTO dto = mapper.toResponseDTO(customer);
        crepo.delete(customer);
        crepo.flush();
        return ResponseEntity.ok("Customer removed : " + dto);
    }
}
