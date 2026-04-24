package com.hyfbe.pet_sitter.repository;

import com.hyfbe.pet_sitter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
