package com.specializedAarea.service;

import com.specializedAarea.model.Doctor;
import com.specializedAarea.model.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty saveSpecialty(Specialty specialty);
    List<Specialty> getSpecialtyById(Integer id);

    List<Doctor> getDoctors(Integer id);
}
