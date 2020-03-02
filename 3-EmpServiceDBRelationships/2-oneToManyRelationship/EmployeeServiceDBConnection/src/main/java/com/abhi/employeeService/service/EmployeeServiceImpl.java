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

    //implement the save() in EmployeeService Interface here
    @Override
    public Employee save(Employee employee){
        //for loop is used to get elements of telephones List
        for (Telephone t: employee.getTelephones()){
            t.setEmployee(employee);
        }
        return employeeRepository.save(employee);
    }


}
