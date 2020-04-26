package com.abhishek.doctor.service;

import com.abhishek.doctor.model.Doctor;
import com.abhishek.doctor.model.Specialty;

import java.util.List;


public interface DoctorService {
    //save doctor
    Doctor save(Doctor doctor);
    //return doctors list by sepecialty id
    List<Doctor> doctorsList(Integer id);
    //get single doctor by doctor id
    Doctor getDoctor(Integer id);
    List<Doctor> getDoctors();

}
