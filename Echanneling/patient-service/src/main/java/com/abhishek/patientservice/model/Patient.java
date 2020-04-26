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
    private  String patientEmail;
    private String gender;
    private String age;
    private String userName;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient")
    List<PatientTelephone> telephones;

    public List<PatientTelephone> getTelephones() { return telephones; }
    //public void setTelephones(List<PatientTelephone> telephones) { this.telephones = telephones; }

}

