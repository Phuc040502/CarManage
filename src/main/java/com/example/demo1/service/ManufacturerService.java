package com.example.task1.service;

import com.example.task1.model.Manufacturer;
import com.example.task1.repository.CarRepository;
import com.example.task1.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CarRepository carRepository;

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        if (manufacturer.getName() == null || manufacturer.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (manufacturerRepository.existsByName(manufacturer.getName())) {
            throw new IllegalArgumentException("Manufacturer name already exists");
        }
        manufacturer.setCreationDate(LocalDateTime.now());
        manufacturer.setUpdateDate(LocalDateTime.now());
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Long id, Manufacturer manufacturer) {
        Manufacturer existing = manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        existing.setName(manufacturer.getName());
        existing.setUpdateDate(LocalDateTime.now());
        return manufacturerRepository.save(existing);
    }

    public void deleteManufacturer(Long id) {
        if (carRepository.existsByManufacturerId(id)) {
            throw new IllegalStateException("Cannot delete manufacturer with existing cars");
        }
        manufacturerRepository.deleteById(id);
    }

    public Manufacturer getManufacturer(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manufacturer not found"));
    }

    public List<Manufacturer> getAllManufacturers(String name) {
        if (name != null) {
            return manufacturerRepository.findByNameContaining(name);
        }
        return manufacturerRepository.findAll();
    }
}
