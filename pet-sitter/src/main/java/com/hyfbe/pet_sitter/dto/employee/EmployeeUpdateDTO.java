package com.hyfbe.pet_sitter.dto.employee;

import lombok.Data;

@Data
public class EmployeeUpdateDTO {
    private String name;
    private String email;
    private String address;
    private String tel;
}
