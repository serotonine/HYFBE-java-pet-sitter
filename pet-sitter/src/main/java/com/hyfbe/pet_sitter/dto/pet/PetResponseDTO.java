package com.hyfbe.pet_sitter.dto.pet;

import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.model.PetType;
import lombok.Data;

@Data
public class PetResponseDTO {
    private String name;
    private Long id;
    private PetType type;
    private Integer age;
  // private CustomerResponseDTO customer;
}
