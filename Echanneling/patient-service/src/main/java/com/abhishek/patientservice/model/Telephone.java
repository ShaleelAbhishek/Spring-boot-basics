package com.abhishek.patientservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String telNumber;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Patient patient;

}
