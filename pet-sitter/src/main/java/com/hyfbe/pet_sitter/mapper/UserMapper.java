package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.dto.user.UserRequestDTO;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // CustomerResponseDTO toResponseDTO(Customer customer);
    @Mapping(target = "customer", ignore = true)
   @Mapping(target = "employee", ignore = true)
    User toEntity(UserRequestDTO dto);

}
