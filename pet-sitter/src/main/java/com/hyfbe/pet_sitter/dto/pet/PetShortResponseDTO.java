package com.hyfbe.pet_sitter.dto.pet;

import com.hyfbe.pet_sitter.model.PetType;
import lombok.Data;

@Data
public class PetShortResponseDTO {
    private String name;
    private Long id;
    private PetType type;
    private Integer age;
    private String comment;
}
