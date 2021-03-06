package com.allocation.controller;


import com.allocation.model.Allocation;
import com.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @PostMapping("/allocationP")
    public String postAllocations(@RequestBody Allocation allocation){
        return allocationService.postAllocation(allocation);
    }

    @GetMapping("/allocation")
    public List<Allocation> getAllocations(){
        return allocationService.getAllocations();
    }

    @GetMapping("/allocationG/{id}")
    public List<Allocation> getAllocationById(@PathVariable("id") Integer empId){
        System.out.println("kkkkkkkkkkkkkkkkkkkkk"+empId);
        return allocationService.getAllocationById(empId);
    }

}
