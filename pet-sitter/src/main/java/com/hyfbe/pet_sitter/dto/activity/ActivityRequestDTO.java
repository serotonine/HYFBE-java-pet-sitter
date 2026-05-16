package com.hyfbe.pet_sitter.dto.activity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityRequestDTO {
    @NotNull
    private Long typeId;
    @NotNull
    private LocalDateTime startDate;
}

