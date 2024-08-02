package com.example.demo1.repository;

import com.example.task1.model.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
    boolean existsByCodeAndManufacturerId(String code, Long manufacturerId);

    List<Accessory> findByNameContaining(String name);

    List<Accessory> findByDescriptionContaining(String description);

    List<Accessory> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Accessory> findByCategoryIdIn(List<Long> categoryIds);

    List<Accessory> findByManufacturerIdIn(List<Long> manufacturerIds);
}
