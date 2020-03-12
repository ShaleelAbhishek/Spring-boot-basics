package com.abhi.employeeService.controller;

import com.abhi.employeeService.model.Employee;
import com.abhi.employeeService.service.EmployeeService;
import com.abhi.employeeService.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
//@RequestMapping("/service")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

        //if you want to create a employee record on db you give POST request.
        //if you want to update a employee record, give PUT.
        //if you want to get the employee record, give GET.
        @RequestMapping(value = "/employee",method = RequestMethod.POST)
        //here with @RequestBody anything comes in the request body, take as Employee object
        public Employee save(@RequestBody Employee employee){
            return employeeService.save(employee);
        }


}
