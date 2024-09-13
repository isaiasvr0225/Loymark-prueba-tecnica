package com.loymark.controller;

import com.loymark.persistence.dto.EmployeeDto;
import com.loymark.service.EmployeeService;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void findAll() {
        // Mock data
        Page<EmployeeDto> mockPage = Page.empty();

        // Mock service behavior
        when(employeeService.findAll(any(Pageable.class))).thenReturn((CompletableFuture<Page<EmployeeDto>>) mockPage);

        // Call the controller method
        ResponseEntity<Page<EmployeeDto>> response = employeeController.findAll(Pageable.unpaged());

        // Verify results
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(mockPage);
    }

    @Test
    void findById() {
        // Mock data
        Long employeeId = 1L;
        EmployeeDto mockEmployeeDto = new EmployeeDto();

        // Mock service behavior
        when(employeeService.findById(employeeId)).thenReturn(mockEmployeeDto);

        // Call the controller method
        ResponseEntity<EmployeeDto> response = employeeController.findById(employeeId);

        // Verify results
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(mockEmployeeDto);

        // Verify that the service method was called
        verify(employeeService).findById(employeeId);
    }
}