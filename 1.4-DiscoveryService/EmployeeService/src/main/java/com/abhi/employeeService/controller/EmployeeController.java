package com.abhi.employeeService.controller;

import com.abhi.employeeService.model.Allocation;
import com.abhi.employeeService.model.Employee;
import com.abhi.employeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/service")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

        //if you want to create a employee record on db you give POST request.
        //if you want to update a employee record, give PUT.
        //if you want to get the employee record, give GET.
        //@RequestMapping(value = "/employee",method = RequestMethod.POST) you can use this instead of @PostMapping
        @PostMapping("/employeeP")
        //here with @RequestBody anything comes in the request body, take as Employee object
        public String save(@RequestBody Employee employee){
            return employeeService.save(employee);
        }

        //this request is used to get all employee details that are in db
        //localhost:port/employeeList
        @GetMapping("/employeeG")
        public List<Employee> getEmployees() {
            return employeeService.getAllEmployees();
        }

        //here you have to use Optional<>
        //you can get employee data by typung id after employeeG/
        @GetMapping("/employeeG/{id}")
        public Employee getEmployeeById(@PathVariable Integer id){
            return employeeService.getEmployeeById(id);
        }

        @GetMapping("employeeAllocation/{empId}")
        public List<Allocation> fetchAllocation(@PathVariable Integer empId){
            return employeeService.fetchAllocation(empId);
        }
}
