package com.hyfbe.pet_sitter.dto.pet;

import lombok.Data;

@Data
public class PetUpdateDTO {
    private String name;
    private Long typeId;
    private Integer age;
    private String comment;
}
