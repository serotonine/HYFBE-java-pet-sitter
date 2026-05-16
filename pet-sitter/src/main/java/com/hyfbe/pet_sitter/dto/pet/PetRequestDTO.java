package com.hyfbe.pet_sitter.dto.pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetRequestDTO {
  @NotBlank
  String name;
  @NotNull
  Long customer;
  @NotNull
  Long type;
  Integer age;
  String comment;
}
