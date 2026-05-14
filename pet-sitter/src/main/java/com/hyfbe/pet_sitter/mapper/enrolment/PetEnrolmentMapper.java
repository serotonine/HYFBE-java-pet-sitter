package com.hyfbe.pet_sitter.mapper.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.mapper.PetMapper;
import com.hyfbe.pet_sitter.model.enrolment.PetEnrolment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetEnrolmentMapper {
    @Mapping(source="id", target="enrolmentId")
    @Mapping(source="pet.id", target="petId")
    @Mapping(source="pet.name", target="petName")
    @Mapping(source="activity.id", target="activityId")
    @Mapping(source="activity.name", target="activityName")
    @Mapping(source="activity.startDate", target="startDate")
    @Mapping(source="activity.endDate", target="endDate")
    PetEnrolmentResponseDTO toResponseDTO(PetEnrolment petEnrolment);
}
