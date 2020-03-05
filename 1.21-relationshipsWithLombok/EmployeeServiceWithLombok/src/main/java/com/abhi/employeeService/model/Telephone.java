package com.abhi.employeeService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tpNumber;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Employee employee;


    public void setEmployee(Employee employee) { this.employee = employee; }

}
