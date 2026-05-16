package com.hyfbe.pet_sitter.dto.employee;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentForEmployeeResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeCompleteResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String tel;
    private String address;
    private List<EmployeeEnrolmentForEmployeeResponseDTO> enrolments;
}
