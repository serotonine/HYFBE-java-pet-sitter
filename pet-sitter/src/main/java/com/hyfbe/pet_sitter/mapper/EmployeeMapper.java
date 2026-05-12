package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {Employee.class})
public interface EmployeeMapper {
    EmployeeResponseDTO toResponseDTO(Employee Employee);
    // Employee toEntity(EmployeeRequestDTO dto);
}
