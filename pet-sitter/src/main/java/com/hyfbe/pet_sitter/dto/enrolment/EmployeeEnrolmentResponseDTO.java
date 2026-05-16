package com.hyfbe.pet_sitter.dto.enrolment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeEnrolmentResponseDTO {
    private Long enrolmentId;
    private String employeeName;
    private Long employeeId;
    private String activityName;
    private Long activityId;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
