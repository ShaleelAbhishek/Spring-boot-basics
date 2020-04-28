package com.abhishek.patientservice.repository;

import com.abhishek.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByPatientId(Integer patientId);
    Patient findByUserName(String userName);
    Patient findByPatientEmail(String patientEmail);
    Patient findByIdCardNumber(String idCardNumber);
    boolean findByActivity(boolean activity);
}
