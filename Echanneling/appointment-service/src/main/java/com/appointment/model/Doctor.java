package com.appointment.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

public class Doctor {
    private Integer doctorId;
    private String doctorName;
    private Integer categoryId;
//    @Transient //this will ignore the specialty as a column in the  Doctor table
//    private Specialty specialty;
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor")
//    List<DoctorTelephone> telephones;
private Specialty specialty;

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
