package com.specializedAarea.controller;

import com.specializedAarea.model.Doctor;
import com.specializedAarea.model.Specialty;
import com.specializedAarea.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @PostMapping("/save")
    public Specialty saveSpecialty(@RequestBody Specialty specialty){
        return specialtyService.saveSpecialty(specialty);
    }

    @GetMapping("/get/{id}")
    public List<Specialty> getSpecialty(@PathVariable("id") Integer id){
        return specialtyService.getSpecialtyById(id);
    }

    @GetMapping("/doctor/{id}")
        public List<Doctor> getDoctors(@PathVariable Integer id){
        return specialtyService.getDoctors(id);
    }
}
