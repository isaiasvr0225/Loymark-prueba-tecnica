package com.loymark.persistence.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * This is a DTO class for Employee error handling
 * @package : com.loymark.persistence.dto
 * @name : EmployeeErrorDto.java
 * @date : 2024-09
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
@Builder
public record EmployeeErrorDto(
        HttpStatus code,
        String message
) implements Serializable {}
