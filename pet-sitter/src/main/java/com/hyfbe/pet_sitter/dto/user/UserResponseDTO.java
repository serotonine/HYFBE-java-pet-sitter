package com.hyfbe.pet_sitter.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.enums.Role;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  // ← ADD THIS
public class UserResponseDTO {
    private Long id;
    private String name;
    private CustomerResponseDTO customer;
    private EmployeeResponseDTO employee;
    private Role role;
}
