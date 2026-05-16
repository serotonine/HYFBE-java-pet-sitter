package com.hyfbe.pet_sitter.dto.activity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActivityTypeRequestDTO {
    @NotBlank
    private String name;
    private Long durationInMinutes;
    // Optional.
    private Integer maxDog;
    private String description;
}
