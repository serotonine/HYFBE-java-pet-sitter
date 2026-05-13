package com.hyfbe.pet_sitter.mapper.activity;

import com.hyfbe.pet_sitter.dto.activity.ActivityRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityResponseDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityUpdateRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.shorts.ActivityShortResponseDTO;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentMapper;
import com.hyfbe.pet_sitter.model.activity.Activity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityShortMapper {

    // GET
    ActivityShortResponseDTO toResponseDTO(Activity entity);
}
