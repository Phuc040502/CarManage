package com.example.task1.controller;

import com.example.task1.model.Car;
import com.example.task1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCar(id));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) List<Long> manufacturerIds,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate) {
        return ResponseEntity.ok(carService.getAllCars(name, manufacturerIds, startDate, endDate));
    }
}
