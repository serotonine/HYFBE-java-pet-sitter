package com.hyfbe.pet_sitter.mapper;

import com.hyfbe.pet_sitter.dto.customer.CustomerCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerResponseDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerUpdateDTO;
import com.hyfbe.pet_sitter.model.Customer;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    // Only id and name fields.
    CustomerResponseDTO toResponseDTO(Customer customer);
    // All fields.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerCompleteResponseDTO toCompleteResponseDTO(Customer customer);
    // Create Customer via User.
    Customer toEntity(CustomerRequestDTO dto);
    // Update any Customer fields.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toUpdatedEntity(CustomerUpdateDTO dto, @MappingTarget Customer customer);

}
