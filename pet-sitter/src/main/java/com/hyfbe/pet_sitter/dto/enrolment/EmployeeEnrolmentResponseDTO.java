package com.hyfbe.pet_sitter.dto.enrolment;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import lombok.Data;

@Data
public class EmployeeEnrolmentResponseDTO {
    private Long enrolmentId;
    private Long activityId;
    private String activityName;
    private Long employeeId;
    private String employeeName;
}
