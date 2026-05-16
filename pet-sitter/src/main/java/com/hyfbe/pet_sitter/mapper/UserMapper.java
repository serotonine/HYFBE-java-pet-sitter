package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.user.UserRequestDTO;
import com.hyfbe.pet_sitter.dto.user.UserResponseDTO;
import com.hyfbe.pet_sitter.model.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponseDTO toResponseDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "customer", ignore = true)
   @Mapping(target = "employee", ignore = true)
    User toEntity(UserRequestDTO dto);

}
