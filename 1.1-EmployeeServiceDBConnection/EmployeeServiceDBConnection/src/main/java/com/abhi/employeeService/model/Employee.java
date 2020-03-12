package com.abhi.employeeService.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private int marks;

    public  Employee(int id,String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Employee(){

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

//    public static List<Employee> getAllEmployees(){
//        List<Employee> employeeList = new ArrayList<>();
//
//        employeeList.add(new Employee(1,"abhi", 50));
//        employeeList.add(new Employee(2,"kasun", 55));
//
//        return employeeList;
//
//    }

}
