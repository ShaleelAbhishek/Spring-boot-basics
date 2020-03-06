package com.abhi.employeeService.service;

import com.abhi.employeeService.Repository.EmployeeRepository;
import com.abhi.employeeService.model.Allocation;
import com.abhi.employeeService.model.Employee;
import com.abhi.employeeService.model.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String save(Employee employee){
        for (Telephone telephone: employee.getTelephones()){
            telephone.setEmployee(employee);
        }
        employeeRepository.save(employee);
        return "data saved";
    }

    //this is used to return findAll method in JpaRepository to show all data it has saved in db
    //this will call after we map the path to Get method in controller with mapping "employeeList"
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //here you use Optional because findById is , "Optional<T> findById(ID id);"
    //you can get employee data by id here
//    @Override
//    public Optional<Employee> getEmployeeById(Integer id) {
//        return employeeRepository.findById(id);
//    }
    //u can use below code instead of above code , line 48-50
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employees = employeeRepository.findById(id);
        if (employees.isPresent())
             return employees.get();
        return null;
    }

    public List<Allocation> fetchAllocation(Integer empId) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        ResponseEntity<Allocation[]> result=restTemplate.exchange("http://localhost:8182/allocationG/"+empId,
                HttpMethod.GET,httpEntity,Allocation[].class);

        Allocation[] resultBody = result.getBody();
        List<Allocation> allocations = new ArrayList<>();

        for (Allocation allocation : resultBody) {
            allocation.setEmployee(this.getEmployeeById(allocation.getEmpId()));
            allocations.add(allocation);
        }
        return allocations;
    }
}
