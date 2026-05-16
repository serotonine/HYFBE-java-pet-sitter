package com.hyfbe.pet_sitter.dto.customer;

import com.hyfbe.pet_sitter.dto.pet.PetShortResponseDTO;
import lombok.Data;
import java.util.List;

@Data
public class CustomerCompleteResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String tel;
    private String email;
    private List<PetShortResponseDTO> pets;
}
