package com.leetjourney.taskmanager.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(
            ConstraintViolationException e) {

        Map<String, Object> response = new HashMap<>();

        String message = e.getConstraintViolations()
                .iterator()
                .next()
                .getMessage();

        return new ResponseEntity<>(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", HttpStatus.BAD_REQUEST.value(),
                        "message", message
                ),
                HttpStatus.BAD_REQUEST);
    }
}
