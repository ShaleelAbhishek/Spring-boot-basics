package com.abhishek.patientservice.service;

import com.abhishek.patientservice.model.Address;
import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.model.Telephone;
import com.abhishek.patientservice.repository.PatientRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Service
@Data
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient){
        //for loop is used to get elements of telephones List
            for (Telephone t: patient.getTelephones()){   //these two methods ()get and set are solved by @Data annotation in Telephone class
                t.setPatient(patient);
            }
            return patientRepository.save(patient);
        }

}
