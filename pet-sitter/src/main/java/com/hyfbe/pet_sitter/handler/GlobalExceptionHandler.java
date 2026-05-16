package com.hyfbe.pet_sitter.handler;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDefinitionException.class)
    public Map<String, Serializable> handleInvalidDefinitionException(InvalidDefinitionException idExc, HttpServletRequest request) {
        return Map.of(
                "error", idExc.getMessage().split("\n"),
                "timestamp", Instant.now().toString(),
                "path", request.getRequestURI(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value())
                //"type", dive.getClass().getSimpleName()
        );
    }
    // MethodArgumentNotValidException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Serializable> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvExc, HttpServletRequest request) {
        return Map.of(
                "error", manvExc.getMessage().split("\n"),
                "timestamp", Instant.now().toString(),
                "path", request.getRequestURI(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "type", manvExc.getClass().getSimpleName()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, Serializable> handleHttpMessageNotReadableException(HttpMessageNotReadableException hmnrExc, HttpServletRequest request) {
        return Map.of(
                "error", hmnrExc.getMessage().split("\n"),
                "timestamp", Instant.now().toString(),
                "path", request.getRequestURI(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value())
        );
    }
}
