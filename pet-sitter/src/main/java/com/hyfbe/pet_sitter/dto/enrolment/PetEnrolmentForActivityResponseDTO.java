package com.hyfbe.pet_sitter.dto.enrolment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PetEnrolmentForActivityResponseDTO {
    private Long id;
    private String name;
    private Integer age;
    private String type;
    private String comment;
    private String customer;
    private Long customerId;

}
