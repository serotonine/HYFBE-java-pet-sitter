package com.hyfbe.pet_sitter.dto.activity;

import lombok.Data;

@Data
public class ActivityTypeUpdateRequestDTO {
    private String name;
    private Long durationInMinutes;
    private Integer maxDog;
    private String description;
}
