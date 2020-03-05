package com.abhi.employeeService.service;

import com.abhi.employeeService.model.Allocation;
import com.abhi.employeeService.model.Employee;

import java.util.List;

//always better to specify interface and do the implementation in the class
public interface EmployeeService {
    String save(Employee employee);
    List<Employee> getAllEmployees();

}
