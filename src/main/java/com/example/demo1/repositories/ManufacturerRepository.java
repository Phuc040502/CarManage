package com.example.demo1.repositories;

import com.example.demo1.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    boolean existsByName(String name);
}
