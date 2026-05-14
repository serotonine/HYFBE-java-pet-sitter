package com.hyfbe.pet_sitter.dto.enrolment;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PetEnrolmentResponseDTO {
    private Long enrolmentId;
    private String petName;
    private Long petId;
    private String activityName;
    private Long activityId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
