package com.loymark.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @package : com.loymark.domain.entity
 * @name : EmployeeEntity.java
 * @date : 2024-09
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public @Entity class EmployeeEntity {

    @Id
    @NotNull
    @Column(nullable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String designation;

    @NotNull
    @Column(nullable = false)
    private Double salary;


}