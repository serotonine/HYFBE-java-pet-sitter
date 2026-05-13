package com.hyfbe.pet_sitter.mapper.enrolment;

import com.hyfbe.pet_sitter.dto.enrolment.EmployeeEnrolmentResponseDTO;
import com.hyfbe.pet_sitter.mapper.activity.ActivityShortMapper;
import com.hyfbe.pet_sitter.model.enrolment.EmployeeEnrolment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper( componentModel = MappingConstants.ComponentModel.SPRING,
uses = {ActivityShortMapper.class})
public interface EmployeeEnrolmentMapper {
    @Mapping(source="id", target="enrolmentId")
    @Mapping(source="employee.id", target="employeeId")
    @Mapping(source="employee.name", target="employeeName")
    @Mapping(source="activity.id", target="activityId")
    @Mapping(source="activity.name", target="activityName")
    EmployeeEnrolmentResponseDTO toResponseDTO(EmployeeEnrolment employeeEnrolment);
}
