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
    public String postAllocation(Allocation allocation){
         allocationRepository.save(allocation);
         return "Data Saved";
    }

    @Override
    public List<Allocation> getAllocations(){
        return allocationRepository.findAll();
    }
}
