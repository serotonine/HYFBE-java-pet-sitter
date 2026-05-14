package com.hyfbe.pet_sitter.mapper.activity;

import com.hyfbe.pet_sitter.dto.activity.*;
import com.hyfbe.pet_sitter.dto.enrolment.PetEnrolmentForActivityResponseDTO;
import com.hyfbe.pet_sitter.mapper.EmployeeMapper;
import com.hyfbe.pet_sitter.mapper.PetMapper;
import com.hyfbe.pet_sitter.mapper.enrolment.EmployeeEnrolmentForActivityMapper;
import com.hyfbe.pet_sitter.mapper.enrolment.EmployeeEnrolmentMapper;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentForActivityMapper;
import com.hyfbe.pet_sitter.mapper.enrolment.PetEnrolmentMapper;
import com.hyfbe.pet_sitter.model.activity.Activity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ActivityTypeMapper.class,
                PetEnrolmentForActivityMapper.class,
                EmployeeEnrolmentForActivityMapper.class
        })
public interface ActivityMapper {

    // POST
    Activity toEntity(ActivityRequestDTO dto);

    // PATCH
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ActivityUpdateRequestDTO dto, @MappingTarget Activity entity);
    // GET
    @Mapping(source="activity.petEnrolments", target="pets")
    @Mapping(source="activity.employeeEnrolments", target="employees")
    ActivityResponseDTO toResponseDTO(Activity activity);
}
