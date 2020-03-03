package com.abhishek.patientservice.service;

import com.abhishek.patientservice.model.Address;
import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }
}
