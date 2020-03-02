package com.abhi.employeeService.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id will be auto generated,hence you dont have to send id in post request.
    private Integer id;
    private String name;
    private int marks;

    public  Employee(int id,String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Employee() { //initialize
    }

    /****************************************************************************/
    //By this one to one relationship is created between Employee and Address. but we dont need to give
    //this in Address class since it's one to one relationship.
    //created address object here.
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

/******************************************************************************/
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

/************************************************************************/
    //
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

}
