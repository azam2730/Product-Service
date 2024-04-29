package com.learning.repository;

import com.learning.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {



}
