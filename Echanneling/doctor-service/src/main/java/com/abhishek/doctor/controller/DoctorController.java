package com.abhishek.doctor.controller;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.model.Specialty;
import com.abhishek.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
    return doctorService.save(doctor);
    }

    @GetMapping("/get/{id}")
    public Doctor getDoctorById(@PathVariable Integer id){
    return doctorService.getDoctorById(id);
    }

    @GetMapping("/doctorSa/{id}")
    public List<Specialty> getSpecialty(@PathVariable Integer id){
        return doctorService.getSpecialty(id);
    }

}
