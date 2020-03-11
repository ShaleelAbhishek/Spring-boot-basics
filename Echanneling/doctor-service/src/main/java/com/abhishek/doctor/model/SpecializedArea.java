package com.abhishek.doctor.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SpecializedArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specializedId;
    private String specializedArea;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "specializedArea")
    List<Doctor> doctors;

}
