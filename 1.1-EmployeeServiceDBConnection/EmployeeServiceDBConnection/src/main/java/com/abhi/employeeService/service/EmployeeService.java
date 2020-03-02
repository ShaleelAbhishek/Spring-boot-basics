package com.abhi.employeeService.service;

import com.abhi.employeeService.model.Employee;

//always better to specify interface and do the implementation in the class
public interface EmployeeService {
    Employee save(Employee employee);
}
