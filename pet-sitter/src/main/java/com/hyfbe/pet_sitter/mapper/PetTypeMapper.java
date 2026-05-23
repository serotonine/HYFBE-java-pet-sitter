package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.dto.pet.PetUpdateDTO;
import com.hyfbe.pet_sitter.model.Pet;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetMapper {
    // Response
    @Mapping(source="pet.customer.id" ,target="customerId")
    @Mapping(source="pet.customer.name" ,target="customerName")
    PetResponseDTO toResponseDTO(Pet pet);

    // Update.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdatedEntity(PetUpdateDTO dto, @MappingTarget Pet pet);
}
