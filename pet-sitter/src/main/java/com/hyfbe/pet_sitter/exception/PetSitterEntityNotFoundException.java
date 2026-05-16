package com.hyfbe.pet_sitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetSitterEntityNotFoundException extends NoSuchElementException {
    public PetSitterEntityNotFoundException(String entity, Long id){
        super(entity + " with id: " + id +" does not exist.");
    }
}
