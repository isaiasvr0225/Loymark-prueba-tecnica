package com.loymark.controller;

import com.loymark.persistence.dto.EmployeeDto;
import com.loymark.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @package : com.loymark.presentation.controller
 * @name : EmployeeController.java
 * @date : 2024-09
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public @RestController class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(this.employeeService.findAll(pageable).join());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.employeeService.findById(id).join());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {

        return ResponseEntity.ok(this.employeeService.save(employeeDto).join());
    }


    // Método opcional en este proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        this.employeeService.delete(id).join();
        return ResponseEntity.ok("Client deleted successfully");
    }
}
