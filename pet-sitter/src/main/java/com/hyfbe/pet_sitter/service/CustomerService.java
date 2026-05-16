package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.customer.CustomerCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerUpdateDTO;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.CustomerMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Pet;
import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CustomerService {

    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repo, CustomerMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    // GET
    @Transactional(readOnly = true)
    public  List<CustomerCompleteResponseDTO> getAllCustomers(){
        List<Customer> customers = repo.findAll();
        return customers.stream().map(mapper::toCompleteResponseDTO).collect(Collectors.toList());
    }

    /**
     *
     * NO CREATE METHOD.
     * A Customer Entity is created ONLY After a User Entity creation.
     * CUSTOMER IS A USER DEPENDENCY.
     *
     */

    // UPDATE
    @Transactional // Better is someone is deleting associated User or Pet or Activity.
    public CustomerCompleteResponseDTO updateCustomer(Long id, CustomerUpdateDTO dto) {
        Customer customer = repo.findById(id).orElseThrow(() -> new PetSitterEntityNotFoundException("Customer", id));
        String name = dto.getName();
        String email = dto.getEmail();
        String tel = dto.getTel();
        String address = dto.getAddress();

        if (name != null) {
            customer.setName(name);
        }
        if (email != null) {
            customer.setEmail(email);
            // Synchronize User name (password)
            User user = customer.getUser();
            if (user != null) {
                user.setName(email);
            }
        }
        if (tel != null) {
            customer.setTel(tel);
        }
        if (address != null) {
            customer.setAddress(address);
        }
        repo.save(customer);
        return mapper.toCompleteResponseDTO(customer);
    }

    // DELETE
    @Transactional // Better is someone is deleting associated User or Pet or Activity.
    public CustomerResponseDTO deleteCustomer(Long id){
        Customer customer = repo.findById(id).orElseThrow(()-> new PetSitterEntityNotFoundException("Customer", id));
        CustomerResponseDTO dto = mapper.toResponseDTO(customer);
        repo.delete(customer);
        return dto;
    }
}
