package com.hyfbe.pet_sitter.dto.activity.shorts;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ActivityShortResponseDTO {
    private Long id;
    private String name;
    // Date
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
