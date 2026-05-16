package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.employee.EmployeeCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeResponseDTO;
import com.hyfbe.pet_sitter.dto.employee.EmployeeUpdateDTO;
import com.hyfbe.pet_sitter.mapper.enrolment.EmployeeEnrolmentMapper;
import com.hyfbe.pet_sitter.model.Employee;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {EmployeeEnrolmentMapper.class})
public interface EmployeeMapper {
    EmployeeResponseDTO toResponseDTO(Employee Employee);

    @Mapping(source = "employeeEnrolments", target = "enrolments")
    EmployeeCompleteResponseDTO toCompleteResponseDTO(Employee employee);
    // Employee toEntity(EmployeeRequestDTO dto);
    // Update.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdatedEntity(EmployeeUpdateDTO dto, @MappingTarget Employee employee);
}
