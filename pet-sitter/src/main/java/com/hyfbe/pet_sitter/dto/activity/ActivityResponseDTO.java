package com.hyfbe.pet_sitter.dto.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentForActivityResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentForActivityResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.model.activity.ActivityType;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
