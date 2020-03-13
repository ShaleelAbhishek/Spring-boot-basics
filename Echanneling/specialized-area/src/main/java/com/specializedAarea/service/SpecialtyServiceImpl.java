package com.specializedAarea.service;

import com.specializedAarea.model.Doctor;
import com.specializedAarea.model.Specialty;
import com.specializedAarea.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //save specialty
    @Override
    public Specialty saveSpecialty(Specialty specialty) {
       return  specialtyRepository.save(specialty);
    }

    //return Specialty list
    @Override
    public List<Specialty> getSpecialtyList() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getSpecialtyById(Integer id) {
        return specialtyRepository.findByCategoryId(id);
    }

    public Specialty getSpecialtById(Integer id) {
        Optional<Specialty> employees = specialtyRepository.findById(id);
        if (employees.isPresent())
            return employees.get();
        return null;
    }

    /*******get doctors List by Specialty Id*******/
    @Override
    public List<Doctor> getDoctors(Integer id) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        ResponseEntity<Doctor[]> result=restTemplate.exchange("http://localhost:8082/doctor/getDoctors/"+id,
                HttpMethod.GET,httpEntity, Doctor[].class);
        Doctor[] resultBody = result.getBody();
        List<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : resultBody) {
            doctor.setSpecialty(this.getSpecialtById(doctor.getCategoryId()));
            doctors.add(doctor);
        }
        return doctors;
    }

}

