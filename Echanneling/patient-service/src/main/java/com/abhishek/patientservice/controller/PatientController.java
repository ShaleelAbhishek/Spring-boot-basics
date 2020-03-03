package com.abhishek.patientservice.controller;

import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/savePatient")
    public Patient postEmployee(@RequestBody Patient patient){
        return patientService.save(patient);
    }

}
