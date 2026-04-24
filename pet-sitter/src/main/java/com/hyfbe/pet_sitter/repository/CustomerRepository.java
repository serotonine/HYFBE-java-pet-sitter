package com.hyfbe.pet_sitter.repository;

import com.hyfbe.pet_sitter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
