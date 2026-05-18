package com.hyfbe.pet_sitter.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {
    private final String token;

}
