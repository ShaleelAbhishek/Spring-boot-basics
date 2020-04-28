package com.abhishek.patientservice.controller;

import com.abhishek.patientservice.model.Patient;
import com.abhishek.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/save")
    public Patient savepatient(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @GetMapping("/getPatient")
    public List<Patient> getPatient(){
        return patientService.getAllPatients();
    }

    @GetMapping("/getPatientById/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }

    @PutMapping("/update")
    public Patient update(@RequestBody Patient patient){
        System.out.println("qwwweee"+patient);
        return patientService.update(patient);
    }
}
