package com.abhishek.doctor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    private String doctorName;
    private Integer categoryId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor")
    List<DoctorTelephone> telephones;

    public List<DoctorTelephone> getTelephones() { return telephones; }
    public void setTelephones(List<DoctorTelephone> telephones) { this.telephones = telephones; }


}
