package com.hyfbe.pet_sitter.dto.activity;

import com.hyfbe.pet_sitter.model.activity.ActivityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityUpdateRequestDTO {
    private String name;
    private Long typeId;
    private LocalDateTime startDate;
}
