package com.loymark.domain.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @package : com.loymark.domain.exception
 * @name : EmployeeException.java
 * @date : 2024-09
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
@Data
public class EmployeeException extends RuntimeException{

    private HttpStatus httpStatus;

    public EmployeeException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
