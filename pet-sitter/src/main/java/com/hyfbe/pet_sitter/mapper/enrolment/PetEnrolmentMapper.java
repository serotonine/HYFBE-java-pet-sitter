package com.hyfbe.pet_sitter.mapper.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.mapper.PetMapper;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
uses={PetMapper.class})
public interface PetEnrolmentMapper {
    PetEnrolmentResponseDTO toResponseDTO(PetEnrolment petEnrolment);
}
