package com.allocation.service;

import com.allocation.model.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation postAllocation(Allocation allocation);
    List<Allocation> getAllocations();
    List<Allocation> getAllocationByEmployeeId(Integer id);
}
