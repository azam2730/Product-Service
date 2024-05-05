package com.learning.controller;

import com.learning.entity.EmployeeEntity;
import com.learning.entity.ProductEntity;
import com.learning.repository.EmployeeRepository;
import com.learning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("saveEmployee")
// return type EmployeeEntity and request payload  employeeEntity

    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {

        EmployeeEntity saveEmployee = employeeService.saveEmployee(employeeEntity);
        return saveEmployee;
    }

    @GetMapping("getEmployee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable long id) {
        EmployeeEntity employeeById = employeeService.getEmployeeById(id);
        return employeeById;
    }

    @DeleteMapping("deleteEmployee/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("getAllEmployee")
    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeService.getAllEmployee();
        return employeeEntities;

    }

    @PutMapping("updateEmployee/{id}")
    public EmployeeEntity updateEmployee(@PathVariable long id, @RequestBody EmployeeEntity updatedEntity){
        EmployeeEntity updateEntity = employeeService.updateEmployee(id, updatedEntity);
        return updateEntity;
    }


}