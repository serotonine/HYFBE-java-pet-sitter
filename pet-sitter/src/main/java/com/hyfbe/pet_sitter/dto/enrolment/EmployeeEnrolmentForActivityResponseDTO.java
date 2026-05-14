package com.hyfbe.pet_sitter.dto.enrolment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeEnrolmentForActivityResponseDTO {
    private String name;
    private String email;
    private String tel;
    private Long id;
}
