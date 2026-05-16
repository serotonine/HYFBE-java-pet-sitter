package com.hyfbe.pet_sitter.dto.enrolment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeEnrolmentForEmployeeResponseDTO {
    private Long enrolmentId;
    private Long activityId;
    private String activityName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
