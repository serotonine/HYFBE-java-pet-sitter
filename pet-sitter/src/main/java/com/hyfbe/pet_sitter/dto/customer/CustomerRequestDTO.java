package com.hyfbe.pet_sitter.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private String tel;
    private String address;
}
