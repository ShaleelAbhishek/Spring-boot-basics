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
    public Allocation save(@RequestBody Allocation allocation){
        return allocationService.save(allocation);
    }

    @GetMapping("/allocationG")
    public List<Allocation> getAllocations(){
        return allocationService.getAllocations();
    }

    @GetMapping("/alloEmp/findByEmployeeId/{id}")
    public List<Allocation> getAllocationByEmployeeId(@PathVariable Integer id){
        return allocationService.getAllocationByEmployeeId(id);
    }

}
