package com.hyfbe.pet_sitter.dto.customer;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private String name;
    private String email;
    private String tel;
    private String address;
}
