package com.abhi.employeeService.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    List<Employee> employees;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
}
