package com.hyfbe.pet_sitter.controller;

import com.hyfbe.pet_sitter.dto.customer.CustomerCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerUpdateDTO;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    // CONSTRUCTOR
    public CustomerController(CustomerService service) {
        this.service = service;
    }
    // GET
    @GetMapping
    public ResponseEntity<List<CustomerCompleteResponseDTO>>getAllCustomers(){
        List<CustomerCompleteResponseDTO> customers = service.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<CustomerCompleteResponseDTO> getCustomerByUserId(
            Authentication authentication
    ){
        CustomerCompleteResponseDTO dto = service.getCustomerByUserId(authentication);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CustomerCompleteResponseDTO> getCustomerById(
            @PathVariable Long id
    ){
        CustomerCompleteResponseDTO customer = service.getCustomerById(id);
        return ResponseEntity.ok().body(customer);
    }

    /**
     *
     * NO CREATE METHOD.
     * A Customer Entity is created ONLY After a User Entity creation.
     * CUSTOMER IS A USER DEPENDENCY.
     *
     */

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerCompleteResponseDTO> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerUpdateDTO dto
            ){
        CustomerCompleteResponseDTO updated = service.updateCustomer(id, dto);
        return ResponseEntity.ok(updated);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(
            @PathVariable Long id
    ){
        CustomerResponseDTO deleted = service.deleteCustomer(id);
        return ResponseEntity.ok(deleted);
    }
}
