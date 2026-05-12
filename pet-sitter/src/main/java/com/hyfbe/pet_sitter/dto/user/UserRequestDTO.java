package com.hyfbe.pet_sitter.dto.user;

import com.hyfbe.pet_sitter.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String password;
    private Long customer;
    private Long employee;
    @Enumerated(EnumType.STRING)
    private String role = Role.CUSTOMER.toString();
}
