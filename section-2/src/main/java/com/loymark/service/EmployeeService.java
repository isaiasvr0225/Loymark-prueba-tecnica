package com.loymark.service;

import com.loymark.persistence.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.CompletableFuture;

/**
 * @package : com.loymark.service
 * @name : EmployeeService.java
 * @date : 2024-09
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
public interface EmployeeService {

    /**
     * This method is used to find all employees using pagination
     * @param Pageable pageable
     * @return CompletableFuture<Page<EmployeeDto>>
     */
    CompletableFuture<Page<EmployeeDto>> findAll(Pageable pageable);

    /**
     * This method is used to find an employee by id
     * @param Long id
     * @return CompletableFuture<EmployeeDto>
     */
    CompletableFuture<EmployeeDto> findById(Long id);

    /**
     * This method is used to save an employee
     * @param EmployeeDto employeeDto
     * @return CompletableFuture<EmployeeDto>
     */
    CompletableFuture<EmployeeDto> save(EmployeeDto employeeDto);


    // Optional method in this project
    CompletableFuture<Void> delete(Long id);

}
