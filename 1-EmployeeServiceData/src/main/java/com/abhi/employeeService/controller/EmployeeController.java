package com.abhi.employeeService.controller;

import com.abhi.employeeService.employee.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/controller")
@XmlRootElement
public class EmployeeController {

    @RequestMapping("/employees")
    public List<Employee> getEmployees(){

       return Employee.getAllEmployees();
    }

}
