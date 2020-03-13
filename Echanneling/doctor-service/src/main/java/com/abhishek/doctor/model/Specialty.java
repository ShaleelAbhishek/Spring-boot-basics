package com.abhishek.doctor.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Specialty {


    //private Integer id;
    private Integer categoryId;
    private String category;
//    private Integer doctorId;

//    private Doctor doctor;
//
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public Integer getDoctorId() {
//        return doctorId;
//    }
//
//    public void setDoctorId(Integer doctorId) {
//        this.doctorId = doctorId;
//    }
}

