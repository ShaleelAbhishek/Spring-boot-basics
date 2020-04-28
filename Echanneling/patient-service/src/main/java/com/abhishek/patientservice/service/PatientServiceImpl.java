package com.abhishek.patientservice.service;

import com.abhishek.patientservice.model.Address;
import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.model.PatientTelephone;
import com.abhishek.patientservice.model.PatientTelephone;
import com.abhishek.patientservice.repository.PatientRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient){
        //for loop is used to get elements of telephones List
            for (PatientTelephone t: patient.getTelephones()){   //these two methods ()get and set are solved by @Data annotation in Telephone class
                t.setPatient(patient);
            }
            return patientRepository.save(patient);
        }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        Optional<Patient> employees = patientRepository.findByPatientId(patientId);
        if (employees.isPresent())
            return employees.get();
        return null;
    }

//    @Override
//    public Patient delete(Patient customerOwner) {
//        if(customerOwner.getPatientId()!=0){
//            for(PatientTelephone telephone:customerOwner.getTelephones())
//                telephone.setPatient(customerOwner);
//        }
//        customerOwner.setDlt(true);
//        return patientRepository.save(customerOwner);
//    }

    @Override
    public Patient update(Patient customerOwner) {
        System.out.println("paitent"+customerOwner);
        if(customerOwner.getPatientId()!=0){
            for(PatientTelephone telephone:customerOwner.getTelephones())
                telephone.setPatient(customerOwner);
        }
        customerOwner.setDlt(false);
        return patientRepository.save(customerOwner);
    }




    @Override
    public Patient findByUserName(String userName) {
        return patientRepository.findByUserName(userName);
    }

    @Override
    public Patient findByEmail(String patientEmail) {
        return patientRepository.findByPatientEmail(patientEmail);
    }

    @Override
    public Patient findByIdCardNumber(String idCardNumber) {
        return patientRepository.findByIdCardNumber(idCardNumber);
    }

    @Override
    public boolean findByActivity(boolean activity) {
        return patientRepository.findByActivity(activity==true);
    }

}
