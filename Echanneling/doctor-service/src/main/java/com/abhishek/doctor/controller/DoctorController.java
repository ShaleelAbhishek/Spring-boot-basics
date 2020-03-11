package com.abhishek.doctor.controller;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

@PostMapping("/saveDoctor")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
    return doctorService.save(doctor);
}




}
