package com.hyfbe.pet_sitter.dto.activity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ActivityUpdateRequestDTO {
    private String name;
    private Long typeId;
    private LocalDateTime startDate;
}
