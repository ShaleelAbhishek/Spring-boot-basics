package com.abhishek.doctor.service;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.model.DoctorTelephone;
import com.abhishek.doctor.model.SpecializedArea;
import com.abhishek.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        for (DoctorTelephone t: doctor.getTelephones()){   //these two methods ()get and set are solved by @Data annotation in Telephone class
            t.setDoctor(doctor);
        }
        return doctorRepository.save(doctor);
    }
}
