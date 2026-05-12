package com.hyfbe.pet_sitter.dto.activity;

import com.hyfbe.pet_sitter.enums.AType;
import lombok.Data;

@Data
public class ActivityTypeResponseDTO {
    private Long id;
    private String name;
    private Long durationInMinutes;
    private String description;
    private Integer maxDog;
}
