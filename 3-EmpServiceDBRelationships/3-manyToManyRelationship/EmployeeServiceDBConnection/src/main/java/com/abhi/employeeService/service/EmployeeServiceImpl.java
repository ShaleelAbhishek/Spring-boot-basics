package com.abhi.employeeService.service;

import com.abhi.employeeService.Repository.EmployeeRepository;
import com.abhi.employeeService.model.Employee;
import com.abhi.employeeService.model.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //this for loop helps to get telephone numbers one by one which an employee has.
    // this should be used because employee and telephone is a OneToMany relationship
    //so the telephone table will keep employee id for all telephone numbers a specific employee has
    public Employee save(Employee employee){
        for (Telephone telephone: employee.getTelephones()){
            telephone.setEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    //this is used to return findAll method in JpaRepository to show all data it has saved in db
    //this will call after we map the path to Get method in controller with mapping "employeeList"
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
