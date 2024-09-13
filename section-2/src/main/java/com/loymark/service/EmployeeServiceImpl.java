package com.loymark.service;
import com.loymark.domain.entity.EmployeeEntity;
import com.loymark.domain.exception.EmployeeException;
import com.loymark.persistence.dto.EmployeeDto;
import com.loymark.persistence.mapper.EmployeeMapper;
import com.loymark.persistence.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @package : com.loymark.service
 * @name : EmployeeServiceImpl.java
 * @date : 2024-09
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */

@RequiredArgsConstructor
public @Service class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;


    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * This method is used to find all employee using pagination, also it is an asynchronous method
     * @param Pageable pageable
     * @return CompletableFuture<Page<EmployeeDto>>
     */
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Page<EmployeeDto>> findAll(Pageable pageable) {

        Page<EmployeeEntity> pageEmployeeEntity = this.employeeRepository.findAll(pageable);

        logger.info("pageEmployeeEntity: " + pageEmployeeEntity);

        if (pageEmployeeEntity.isEmpty()) {
            logger.error("Internal server error");
            throw new EmployeeException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Page<EmployeeDto> pageClientDto = pageEmployeeEntity.map(this.employeeMapper::toDto);

        logger.info("pageClientDto: " + pageClientDto);

        return CompletableFuture.completedFuture(pageClientDto);
    }

    /**
     * This method is used to find a employee by id and cache, also it is an asynchronous method
     * @param Long id
     * @return CompletableFuture<EmployeeDto>
     */
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<EmployeeDto> findById(Long id) {

        logger.info("id: " + id);

        EmployeeEntity employeeEntity = this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeException("Client not found", HttpStatus.NOT_FOUND));

        logger.info("employeeEntity: " + employeeEntity);

        EmployeeDto clientDto = this.employeeMapper.toDto(employeeEntity);

        logger.info("clientDto: " + clientDto);

        return CompletableFuture.completedFuture(clientDto);

    }

    /**
     * This method is used to save a employee, also it is an asynchronous method
     * @param EmployeeDto employeeDto
     * @return CompletableFuture<EmployeeDto>
     */
    @Override
    public CompletableFuture<EmployeeDto> save(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            logger.error("EmployeeDto must not be null");
            throw new EmployeeException("EmployeeDto must not be null", HttpStatus.BAD_REQUEST);
        }

        EmployeeEntity employeeEntity = this.employeeMapper.toEntity(employeeDto);

        EmployeeEntity savedEmployeeEntity = this.employeeRepository.save(employeeEntity);

        EmployeeDto savedEmployeeDto = this.employeeMapper.toDto(savedEmployeeEntity);

        return CompletableFuture.completedFuture(savedEmployeeDto);
    }


    /**
     * This method is used to delete a client, also it is an asynchronous method
     * @param Long id
     * @return CompletableFuture<Void>
     */
    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Void> delete(Long id) {

        if (id == null) {
            logger.error("Id must not be null");
            throw new EmployeeException("Id must not be null", HttpStatus.BAD_REQUEST);
        }

        return CompletableFuture.runAsync(() -> {
            logger.info("Deleting employee with Id: " + id);
            this.employeeRepository.deleteById(id);
        });
    }


}
