package com.hyfbe.pet_sitter.dto.activity;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentForActivityResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentForActivityResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActivityResponseDTO {
    private Long id;
    private String name;
    private ActivityTypeResponseDTO type;
    // Date
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    // Enrolment
    private List<PetEnrolmentForActivityResponseDTO> pets;
    private List<EmployeeEnrolmentForActivityResponseDTO> employees;
}
