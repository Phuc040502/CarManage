package com.example.demo1.repository;

import com.example.task1.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    boolean existsByName(String name);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Car c WHERE c.manufacturer.id = :manufacturerId")
    boolean existsByManufacturerId(@Param("manufacturerId") Long manufacturerId);

    List<Manufacturer> findByNameContaining(String name);
}
