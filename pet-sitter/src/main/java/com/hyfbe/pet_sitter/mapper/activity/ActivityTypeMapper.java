package com.hyfbe.pet_sitter.mapper.activity;

import com.hyfbe.pet_sitter.dto.activity.ActivityTypeRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeResponseDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeShortRequestDTO;
import com.hyfbe.pet_sitter.dto.activity.ActivityTypeUpdateRequestDTO;
import com.hyfbe.pet_sitter.model.activity.ActivityType;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityTypeMapper {

    // POST
    ActivityType toEntity(ActivityTypeRequestDTO dto);

    ActivityTypeShortRequestDTO toShortEntity(ActivityType entity);

    // PATCH
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ActivityTypeUpdateRequestDTO dto, @MappingTarget ActivityType entity);

    // GET
    ActivityTypeResponseDTO toResponseDTO(ActivityType entity);

}
