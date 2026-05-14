package com.hyfbe.pet_sitter.mapper.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentForActivityResponseDTO;
import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PetEnrolmentForActivityMapper {
    @Mapping(source="pet.id", target="id")
    @Mapping(source="pet.name", target="name")
    @Mapping(source="pet.age", target="age")
    @Mapping(source="pet.type.name", target="type")
    @Mapping(source="pet.customer.name", target="customer")
    @Mapping(source="pet.customer.id", target="customerId")
    @Mapping(source="pet.comment", target="comment")
    PetEnrolmentForActivityResponseDTO toResponseDTO(PetEnrolment petEnrolment);
}
