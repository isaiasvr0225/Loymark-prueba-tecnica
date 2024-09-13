package com.loymark.persistence.repository;

import com.loymark.domain.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is used to manage the Employee repository, it extends from JpaRepository interface
 * @package : com.loymark.persistence.repository
 * @name : EmployeeRepository.java
 * @date : 2024-09
 * @author : Isaias Villarreal
 * @version : 1.0.0
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {}
