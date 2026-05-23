package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.pet.PetTypeResponseDTO;
import com.hyfbe.pet_sitter.model.PetType;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetTypeMapper {
    // Response
    PetTypeResponseDTO toResponseDTO(PetType type);

}
