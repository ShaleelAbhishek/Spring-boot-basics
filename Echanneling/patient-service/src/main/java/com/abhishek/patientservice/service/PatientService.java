package com.abhishek.patientservice.service;

import com.abhishek.patientservice.model.Patient;

import java.util.List;

public interface PatientService {
    Patient save(Patient patient);

    List<Patient> getAllPatients();
}
