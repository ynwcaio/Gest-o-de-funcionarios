package com.api.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class GlobalHandlerException  {
    @ExceptionHandler(EmployeeNotFound.class)

    public ResponseEntity<Set<String>> handleEmployeeNotFound(EmployeeNotFound e){

        Set<String> message = new HashSet<>();

        message.add("Timestamp: " + LocalDateTime.now());

        message.add("Https Status: " + HttpStatus.NOT_FOUND.value());

        message.add("Error: " + e.getMessage());

        return ResponseEntity.status
                (HttpStatus.NOT_FOUND)
                .body(message);
    }

}
