package com.example.task1.service;

import com.example.task1.model.Accessory;
import com.example.task1.repository.AccessoryRepository;
import com.example.task1.repository.CarRepository;
import com.example.task1.repository.CategoryRepository;
import com.example.task1.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Accessory createAccessory(Accessory accessory) {
        if (accessory.getName() == null || accessory.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (accessory.getCode() == null || accessory.getCode().isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if (accessory.getPrice() == null || accessory.getPrice() <= 0) {  // Kiểm tra null trước rồi so sánh với 0
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (!manufacturerRepository.existsById(accessory.getManufacturer().getId())) {
            throw new IllegalArgumentException("Manufacturer does not exist");
        }
        if (!carRepository.existsById(accessory.getCar().getId())) {
            throw new IllegalArgumentException("Car does not exist or does not belong to the specified manufacturer");
        }
        if (!categoryRepository.existsById(accessory.getCategory().getId())) {
            throw new IllegalArgumentException("Category does not exist");
        }
        accessory.setCreationDate(LocalDateTime.now());
        accessory.setUpdateDate(LocalDateTime.now());
        return accessoryRepository.save(accessory);
    }

    public Accessory updateAccessory(Long id, Accessory accessory) {
        Accessory existing = accessoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Accessory not found"));
        existing.setName(accessory.getName());
        existing.setCode(accessory.getCode());
        existing.setDescription(accessory.getDescription());
        existing.setPrice(accessory.getPrice());
        existing.setUpdateDate(LocalDateTime.now());
        return accessoryRepository.save(existing);
    }

    public void deleteAccessory(Long id) {
        Accessory accessory = accessoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Accessory not found"));
        if (accessory.getAttachments() != null && !accessory.getAttachments().isEmpty()) {
            throw new IllegalStateException("Cannot delete accessory with existing attachments");
        }
        accessoryRepository.deleteById(id);
    }

    public Accessory getAccessory(Long id) {
        return accessoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Accessory not found"));
    }

    public List<Accessory> getAllAccessories(String name, String description, Double minPrice, Double maxPrice, List<Long> categoryIds, List<Long> manufacturerIds) {
        if (name != null) {
            return accessoryRepository.findByNameContaining(name);
        }
        if (description != null) {
            return accessoryRepository.findByDescriptionContaining(description);
        }
        if (minPrice != null && maxPrice != null) {
            return accessoryRepository.findByPriceBetween(minPrice, maxPrice);
        }
        if (categoryIds != null && !categoryIds.isEmpty()) {
            return accessoryRepository.findByCategoryIdIn(categoryIds);
        }
        if (manufacturerIds != null && !manufacturerIds.isEmpty()) {
            return accessoryRepository.findByManufacturerIdIn(manufacturerIds);
        }
        return accessoryRepository.findAll();
    }
}

