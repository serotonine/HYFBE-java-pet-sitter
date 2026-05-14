package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.pet.PetResponseDTO;
import com.hyfbe.pet_sitter.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetMapper {
    PetResponseDTO toResponseDTO(Pet pet);
    /*private final CustomerMapper customerMapper;

    public PetMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public PetResponseDTO toResponseDTO(Pet pet){
        PetResponseDTO dto = new PetResponseDTO();
        dto.setName(pet.getName());
        dto.setId(pet.getId());
        dto.setType(pet.getType());
        dto.setAge(pet.getAge());
        dto.setCustomer(customerMapper.toResponseDTO(pet.getCustomer()));
        return dto;
    }*/
}
