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
    public Allocation postAllocations(@RequestBody Allocation allocation){
        return allocationService.postAllocation(allocation);
    }

    @GetMapping("/allocationG")
    public List<Allocation> getAllocations(){
        return allocationService.getAllocations();
    }

    @GetMapping("/allocationEmp/findByEmployeeId/{id}")
    public List<Allocation> getAllocationByEmployeeId(@PathVariable Integer id){
        return allocationService.getAllocationByEmployeeId(id);
    }

}
