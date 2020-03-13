package com.specializedAarea.service;

import com.specializedAarea.model.Doctor;
import com.specializedAarea.model.Specialty;

import java.util.List;

public interface SpecialtyService {
    //save specialty
    Specialty saveSpecialty(Specialty specialty);
    //return specialties list
    List<Specialty> getSpecialtyList();
    //return doctors by specialty id
    List<Doctor> getDoctors(Integer id);
    Specialty getSpecialtyById(Integer id);

}
