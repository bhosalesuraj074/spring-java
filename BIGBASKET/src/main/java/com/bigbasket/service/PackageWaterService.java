package com.bigbasket.service;

import com.bigbasket.models.PackageWater;
import com.bigbasket.repository.PackageWaterRepository;
import com.bigbasket.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageWaterService {
    @Autowired
    private PackageWaterRepository repository;


    // Method to create a new PackageWater instance
    public PackageWater createPackageWater(PackageWater packageWater) {
        return repository.save(packageWater);
    }

    // Method to retrieve a PackageWater instance by ID
    public PackageWater getPackageWaterById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PackageWater not found with id: " + id));
    }


    public List<PackageWater> getAllPackageWater() {
        return repository.findAll();
    }

    public void deletePackageWater(Long id) {
        PackageWater packageWater = getPackageWaterById(id);
        repository.delete(packageWater);
    }
}
