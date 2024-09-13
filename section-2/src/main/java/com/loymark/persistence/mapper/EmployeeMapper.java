package com.loymark.persistence.mapper;

import com.loymark.domain.entity.EmployeeEntity;
import com.loymark.persistence.dto.EmployeeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {


    EmployeeEntity toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(EmployeeEntity employeeEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EmployeeEntity partialUpdate(EmployeeDto employeeDto, @MappingTarget EmployeeEntity employeeEntity);
}