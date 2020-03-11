package com.abhishek.patientservice.controller;

import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/savePatient")
    public Patient savepatient(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @GetMapping("/getPatient")
    public List<Patient> getPatient(){
        return patientService.getAllPatients();
    }
}
