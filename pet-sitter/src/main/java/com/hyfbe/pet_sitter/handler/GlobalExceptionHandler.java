package com.hyfbe.pet_sitter.handler;

import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // FindById()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PetSitterEntityNotFoundException.class)
    public Map<String, String> handleMovieNotFound(PetSitterEntityNotFoundException psenfe) {
        return Map.of(
                "error", psenfe.getMessage(),
                "timestamp", Instant.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "status-explanation", HttpStatus.NOT_FOUND.getReasonPhrase().toString()
        );
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleDataIntegrityViolationException(DataIntegrityViolationException dive, HttpServletRequest request) {
        return Map.of(
                "error", dive.getMessage(),
                "timestamp", Instant.now().toString(),
                "path", request.getRequestURI(),
                "status", String.valueOf(HttpStatus.CONFLICT.value()),
                "type", dive.getClass().getSimpleName()
        );
    }
}
