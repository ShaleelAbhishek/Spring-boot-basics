package com.abhishek.patientservice.model;


import lombok.Data;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String patientName;
    private String gender;
    private String age;
    private String user_name;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    List<Telephone> telephones;

    public List<Telephone> getTelephones() { return telephones; }
    public void setTelephones(List<Telephone> telephones) { this.telephones = telephones; }

}

