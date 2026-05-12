package com.hyfbe.pet_sitter.dto.enrolment;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import lombok.Data;

@Data
public class PetEnrolmentResponseDTO {
    private Long id;
    private PetResponseDTO pet;
}
