package com.allocation.service;

import com.allocation.model.Allocation;

import java.util.List;

public interface AllocationService {
    String postAllocation(Allocation allocation);
    List<Allocation> getAllocations();
    List<Allocation> getAllocationById(Integer id);
}
