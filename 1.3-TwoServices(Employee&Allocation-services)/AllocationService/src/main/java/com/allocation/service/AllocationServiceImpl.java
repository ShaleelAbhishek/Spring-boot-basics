package com.allocation.service;

import com.allocation.model.Allocation;
import com.allocation.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation save(Allocation allocation){
        return allocationRepository.save(allocation);
    }

    @Override
    public List<Allocation> getAllocations(){
        return allocationRepository.findAll();
    }

//    public List<Allocation> getAllocationByEmployeeId(Integer id){
//        return allocationRepository.findByEmpId(id);
//    }

    //you can use above commented (line 27-29) code with an abstract method in AllocationRepository
    //or else below code
    public List<Allocation> getAllocationByEmployeeId(Integer id){

        Allocation allocation = new Allocation();
        allocation.setEmpId(id);
        Example<Allocation> employeeExample = Example.of(allocation);

        return allocationRepository.findAll(employeeExample);

    }
}
