package com.abhishek.doctor.service;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.model.DoctorTelephone;
import com.abhishek.doctor.model.Specialty;
import com.abhishek.doctor.repository.DoctorRepository;
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
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //Doctor Save
    @Override
    public Doctor save(Doctor doctor) {
        for (DoctorTelephone t: doctor.getTelephones()){   //these two methods ()get and set are solved by @Data annotation in Telephone class
            t.setDoctor(doctor);
        }
        return doctorRepository.save(doctor);
    }

    //return Doctor by Specialty Id to Specilty Service
    @Override
    public List<Doctor> doctorsList(Integer id) {
        return doctorRepository.findByCategoryId(id);

    }

    //get Doctor By ID
    public Doctor getDoctorById(Integer id) {
        Optional<Doctor> employees = doctorRepository.findByDoctorId(id);
        if (employees.isPresent())
            return employees.get();
        return null;
    }

    //get Doctor with Specialty by doctor ID
    public Doctor getDoctor(Integer doctorId) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        Doctor doctor=this.getDoctorById(doctorId);

        ResponseEntity<Specialty> result=restTemplate.exchange("http://localhost:8083/specialty/doctors/"+doctor.getCategoryId(),
                HttpMethod.GET,httpEntity, Specialty.class);
        doctor.setSpecialty(result.getBody());
        return doctor;
    }
}
