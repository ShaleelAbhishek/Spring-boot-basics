package com.abhishek.doctor.controller;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.model.Specialty;
import com.abhishek.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    /****************Save Doctor*****************/
    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
    return doctorService.save(doctor);
    }

    /*******return doctor by Specilty Id to Specialty service****/
    @GetMapping("/getDoctors/{id}")
    public List<Doctor> doctorsList(@PathVariable Integer id){
        return doctorService.doctorsList(id);
    }

    /**********get doctor with specialty by doctor Id**********/
    @GetMapping("/getDoctor/{id}")
    public Doctor getDoctor(@PathVariable Integer id){
        return doctorService.getDoctor(id);
    }

    /********get all doctors***********************************/
    @GetMapping("/getDoctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getDoctors();
    }

}
