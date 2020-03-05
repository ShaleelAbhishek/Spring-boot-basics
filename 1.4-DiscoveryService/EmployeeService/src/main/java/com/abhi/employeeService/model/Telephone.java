package com.abhi.employeeService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tpNumber;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Employee employee;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTpNumber() { return tpNumber; }
    public void setTpNumber(String tpNumber) { this.tpNumber = tpNumber; }

    /******************************************************************************/

    //this geeters and setters are need to be added, in serviceImpl  these two functions are called in
    //for loop
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
