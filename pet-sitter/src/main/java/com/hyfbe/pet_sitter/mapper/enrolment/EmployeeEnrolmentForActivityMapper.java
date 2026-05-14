package com.hyfbe.pet_sitter.mapper.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentForActivityResponseDTO;
import com.hyfbe.pet_sitter.model.enrolment.EmployeeEnrolment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper( componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeEnrolmentForActivityMapper {
    @Mapping(source="employee.id", target="id")
    @Mapping(source="employee.name", target="name")
    @Mapping(source="employee.email", target="email")
    @Mapping(source="employee.tel", target="tel")
    EmployeeEnrolmentForActivityResponseDTO toResponseDTO(EmployeeEnrolment employeeEnrolment);
}
