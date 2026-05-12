package com.hyfbe.pet_sitter.dto.activity;

import com.hyfbe.pet_sitter.enums.AType;
import com.hyfbe.pet_sitter.model.activity.Activity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActivityTypeRequestDTO {
    @NotBlank
    private String name;
    private Long durationInMinutes;
    // Optional.
    private Integer maxDog;
    private String description;
}
