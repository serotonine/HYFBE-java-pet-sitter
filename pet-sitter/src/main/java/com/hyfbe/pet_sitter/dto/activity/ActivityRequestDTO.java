package com.hyfbe.pet_sitter.dto.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hyfbe.pet_sitter.model.activity.ActivityType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ActivityRequestDTO {
    @NotNull
    private Long typeId;
    @NotNull
    private LocalDateTime startDate;
}

