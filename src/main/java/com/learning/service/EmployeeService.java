package com.learning.service;

import com.learning.entity.EmployeeEntity;
import com.learning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity){
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return savedEmployee;
    }
    public EmployeeEntity getEmployeeById(long id){
        Optional<EmployeeEntity> saveEmployeebyId = employeeRepository.findById(id);
        return saveEmployeebyId.get();
    }

    public void deleteEmployeeById(long id){
        employeeRepository.deleteById(id);
    }

    public List<EmployeeEntity> getAllEmployee(){
        List<EmployeeEntity> all = employeeRepository.findAll();
       return all;
    }

    public EmployeeEntity updateEmployee(long id, EmployeeEntity updateEntity){
        Optional<EmployeeEntity> savedEmployee = employeeRepository.findById(id);
        EmployeeEntity employeeEntity = savedEmployee.get();
        employeeEntity.setEmployeeName(updateEntity.getEmployeeName());
        employeeEntity.setMobileNUmber(updateEntity.getMobileNUmber());
        employeeEntity.setEmployeeStatus(updateEntity.getEmployeeStatus());
        EmployeeEntity updatedProduct = employeeRepository.save(employeeEntity);
        return updatedProduct;

    }
}
