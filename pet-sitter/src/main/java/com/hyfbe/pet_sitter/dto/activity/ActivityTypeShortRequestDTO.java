package com.hyfbe.pet_sitter.dto.activity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActivityTypeShortRequestDTO {
    @NotNull
    private Long id;
}
