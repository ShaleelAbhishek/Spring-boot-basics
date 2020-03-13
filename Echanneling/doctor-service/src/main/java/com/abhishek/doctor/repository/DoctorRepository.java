package com.abhishek.doctor.repository;

import com.abhishek.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    //return doctor by Specialty Id
    List<Doctor> findByCategoryId(Integer id);
    //return doctor by doctor Id
    Optional<Doctor> findByDoctorId(Integer id);
}
