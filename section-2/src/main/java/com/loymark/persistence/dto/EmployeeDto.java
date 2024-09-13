package com.loymark.persistence.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.loymark.domain.entity.EmployeeEntity}
 */
@NoArgsConstructor(force = true)
public record EmployeeDto(
        @NotNull Long id,

        @NotNull @NotBlank String name,

        @NotNull @NotBlank String designation,
        @NotNull Double salary) implements Serializable {
}