package com.abhi.employeeService.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int marks;

    /****************************************************************************/
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    //in OneToMany relationship, employeeId will show in telephone table.
    //we use a List of Telephgones here because there are many telephone numbers for one employee(we didnt add it in Address)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Telephone> telephones;


    @ManyToMany(cascade = CascadeType.ALL)
    //in ManyToMany relationship, there will be create a new table to map both tables' data
    //so we have to give @joinTable because this is a many to many realtionship.
    //this will create a new table called project_employee,including projectId and EmployeeId
    @JoinTable(name="project_employee",
        joinColumns= @JoinColumn (name="eid", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="pid",referencedColumnName="id"))
    List<Project> projects;

    public List<Telephone> getTelephones() { return telephones; }
    public void setTelephones(List<Telephone> telephones) { this.telephones = telephones; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }
}
