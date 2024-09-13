package com.loymark.controller;

import com.loymark.domain.exception.EmployeeException;
import com.loymark.persistence.dto.EmployeeErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @package : com.loymark.presentation.controller
 * @name : EmployeeControllerAdvice.java
 * @date : 2024-09
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
@RestControllerAdvice
public class EmployeeControllerAdvice {

    /**
     * This method is used to handle EmployeeException
     * @param EmployeeException employeeException
     * @return ResponseEntity<EmployeeErrorDto>
     */
    @ExceptionHandler(value = EmployeeException.class)
    public ResponseEntity<EmployeeErrorDto> handleEmployeeException(EmployeeException employeeException) {
        return ResponseEntity.status(employeeException.getHttpStatus()).body(EmployeeErrorDto.builder()
                .code(employeeException.getHttpStatus())
                .message(employeeException.getMessage())
                .build());
    }
}
