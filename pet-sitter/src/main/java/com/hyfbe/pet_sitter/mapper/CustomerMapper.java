package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerResponseDTO toResponseDTO(Customer customer);
    Customer toEntity(CustomerRequestDTO dto);

}
