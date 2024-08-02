//package com.example.demo1.repositories;
//
//import com.example.demo1.model.Car;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface CarRepository extends JpaRepository<Car, Long> {
//    boolean existsByNameAndManufacturerId(String name, Long manufacturerId);
//    List<Car> findByManufacturerId(Long manufacturerId);
//}
