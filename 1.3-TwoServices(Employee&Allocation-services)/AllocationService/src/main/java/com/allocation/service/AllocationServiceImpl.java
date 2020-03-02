package com.allocation.service;

import com.allocation.model.Allocation;
import com.allocation.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Allocation> getAllocationByEmployeeId(Integer id){
        return allocationRepository.findByEmployeeId(id);
    }
}
