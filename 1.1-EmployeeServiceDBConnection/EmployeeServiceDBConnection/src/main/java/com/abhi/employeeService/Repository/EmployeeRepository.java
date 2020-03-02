package com.abhi.employeeService.Repository;

import com.abhi.employeeService.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//you have given Integer, because its Employee class's id's type.
//it will take as primary key. so you have to give it here as Integer
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //if you dont use extend from jpaRepository, you have to call save method here.
    //Employee save(Employee employee);
}
