package com.abhi.employeeService.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int marks;

    public  Employee(int id,String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Employee() {
    }

    /****************************************************************************/
    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    //since one employee has many numbers, you have to create an object(telephones) of List of Telephone here
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Telephone> telephones;

/******************************************************************************/
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }

/************************************************************************/
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Telephone> getTelephones() { return telephones; }
    public void setTelephones(List<Telephone> telephones) { this.telephones = telephones; }

}
