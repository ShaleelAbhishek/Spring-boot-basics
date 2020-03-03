package com.abhi.employeeService.service;

import com.abhi.employeeService.model.Allocation;
import com.abhi.employeeService.model.Employee;

import java.util.List;
import java.util.Optional;

//always better to specify interface and do the implementation in the class
public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

//    Employee findById(Integer empId);

    List<Allocation> fetchEmployeeAllocation();
}
