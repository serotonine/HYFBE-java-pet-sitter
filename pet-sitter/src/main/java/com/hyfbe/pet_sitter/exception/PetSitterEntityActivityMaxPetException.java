package com.hyfbe.pet_sitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PetSitterEntityActivityMaxPetException extends NoSuchElementException {
    public PetSitterEntityActivityMaxPetException(){
        super("This activity has reached the maximum pet enrolment.");
    }
}
