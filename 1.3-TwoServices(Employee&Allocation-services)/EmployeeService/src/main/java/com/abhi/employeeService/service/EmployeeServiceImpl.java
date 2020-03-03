package com.abhi.employeeService.service;

import com.abhi.employeeService.Repository.EmployeeRepository;
import com.abhi.employeeService.model.Allocation;
import com.abhi.employeeService.model.Employee;
import com.abhi.employeeService.model.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

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




    public Employee findById(Integer empId){
        Optional<Employee> employees = employeeRepository.findById(empId);
        if (employees.isPresent())
            return employees.get();
        return null;
    }


    @Value("${service.host}")
    private String allocationServiceHost;

    @Value("${service.allocation.findAll}")
    private String findAll;

    @Value("${service.allocation.findByEmployeeId}")
    private String findByEmployeeIdURI;


    @Override
    public List<Allocation> fetchEmployeeAllocation() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Allocation[]> result = restTemplate.getForEntity(allocationServiceHost + findAll, Allocation[].class);

        Allocation[] resultBody = result.getBody();

        List<Allocation> allocations = new ArrayList<>();

        for (Allocation allocation : resultBody) {
            allocation.setEmployee(this.findById(allocation.getEmpId()));
            allocations.add(allocation);
        }


        return allocations;
    }


}
