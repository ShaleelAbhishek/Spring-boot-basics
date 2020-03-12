package com.abhishek.doctor.service;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.model.Specialty;

import java.util.List;


public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor getDoctorById(Integer id);
    List<Specialty> getSpecialty(Integer id);


}
