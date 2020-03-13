package com.specializedAarea.repository;

import com.specializedAarea.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty,Integer> {


    /*****return Specialty by doctor Id*****/
    Specialty findByCategoryId(Integer id);


}
