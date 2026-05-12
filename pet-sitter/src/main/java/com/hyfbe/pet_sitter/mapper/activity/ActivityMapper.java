package com.hyfbe.pet_sitter.mapper.activity;

import com.hyfbe.pet_sitter.dto.activity.*;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentMapper;
import com.hyfbe.pet_sitter.model.activity.Activity;
import com.hyfbe.pet_sitter.model.activity.ActivityType;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ActivityTypeMapper.class, PetEnrolmentMapper.class})
public interface ActivityMapper {

    // POST
    Activity toEntity(ActivityRequestDTO dto);

    // PATCH
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ActivityUpdateRequestDTO dto, @MappingTarget Activity entity);

    // GET
    ActivityResponseDTO toResponseDTO(Activity entity);
}
