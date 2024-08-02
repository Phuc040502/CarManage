package com.example.demo1.repository;

import com.example.task1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByNameContaining(String name);

    List<Car> findByManufacturerIdIn(List<Long> manufacturerIds);

    List<Car> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Car c WHERE c.name = :name AND c.manufacturer.id = :manufacturerId")
    boolean existsByNameAndManufacturerId(@Param("name") String name, @Param("manufacturerId") Long manufacturerId);

    boolean existsByManufacturerId(Long id);
}



