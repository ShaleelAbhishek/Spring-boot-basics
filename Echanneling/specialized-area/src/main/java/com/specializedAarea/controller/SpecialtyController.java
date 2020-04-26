package com.specializedAarea.controller;

import com.specializedAarea.model.Doctor;
import com.specializedAarea.model.Specialty;
import com.specializedAarea.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    //Specialty Save
    @PostMapping("/save")
    public Specialty saveSpecialty(@RequestBody Specialty specialty){
        return specialtyService.saveSpecialty(specialty);
    }

    //return specialties
    @GetMapping("/getSpecialties")
    public List<Specialty> getSpecialties(){
        return specialtyService.getSpecialtyList();
    }

    //return specialty by doctor id to doctor service
    @GetMapping("/getSpecialtyById/{id}")
    public Specialty getSpecialtyById(@PathVariable("id") Integer id){
        return specialtyService.getSpecialtyById(id);
    }

    //get doctors list by specialty Id
    @GetMapping("/doctors/{id}")
        public List<Doctor> getDoctorsByCategoryId(@PathVariable Integer id){
        return specialtyService.getDoctors(id);
    }


}
