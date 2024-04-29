package com.learning.controller;

import com.learning.entity.EmployeeEntity;
import com.learning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("saveEmployee")
// return type EmployeeEntity and request payload  employeeEntity

    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {

        EmployeeEntity saveEmployee = employeeRepository.save(employeeEntity);
        return saveEmployee;
    }

    @GetMapping("getEmployee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.get();
    }

    @DeleteMapping("deleteEmployee/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("getAllEmployee")
    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities;

    }
}