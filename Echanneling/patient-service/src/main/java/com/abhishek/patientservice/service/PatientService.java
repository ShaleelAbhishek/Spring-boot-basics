package com.abhishek.patientservice.service;

import com.abhishek.patientservice.model.Patient;

import java.util.List;

public interface PatientService {
    Patient findByUserName(String userName);
    Patient findByEmail(String patientEmail);
    Patient findByIdCardNumber(String idCardNumber);
    boolean findByActivity(boolean activity);


    Patient save(Patient patient);
    Patient update(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(Integer id);
}
