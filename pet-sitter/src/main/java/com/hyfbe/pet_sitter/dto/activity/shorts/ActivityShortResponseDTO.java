package com.hyfbe.pet_sitter.dto.activity.shorts;

import com.hyfbe.pet_sitter.dto.activity.ActivityTypeResponseDTO;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;

import java.time.LocalDateTime;
import java.util.List;

public class ActivityShortResponseDTO {
    private Long id;
    private String name;
    // Date
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
