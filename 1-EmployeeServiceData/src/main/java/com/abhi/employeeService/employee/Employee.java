package com.abhi.employeeService.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private int marks;

    public Employee(String name, int marks){
        this.marks=marks;
        this.name = name;
    }

//    public Employee() {
//
//    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getMarks() { return marks; }

    public void setMarks(int marks) { this.marks = marks; }

    public static List<Employee> getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("abhi", 50));
        employeeList.add(new Employee("kasun", 55));

        return employeeList;

    }
}
