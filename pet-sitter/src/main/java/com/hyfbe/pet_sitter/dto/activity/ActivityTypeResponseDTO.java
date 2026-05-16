package com.hyfbe.pet_sitter.dto.activity;

import lombok.Data;

@Data
public class ActivityTypeResponseDTO {
    private Long id;
    private String name;
    private Long durationInMinutes;
    private String description;
    private Integer maxDog;
}
