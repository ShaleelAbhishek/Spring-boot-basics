package com.abhi.employeeService.service;

import com.abhi.employeeService.Repository.EmployeeRepository;
import com.abhi.employeeService.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
}
