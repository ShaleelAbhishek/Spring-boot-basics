package com.abhi.employeeService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//here id is primary key and its auto generated when you post data
    private Integer id;
    private String city;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
