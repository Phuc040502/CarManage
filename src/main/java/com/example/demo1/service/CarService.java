package com.example.task1.service;

import com.example.task1.model.Car;
import com.example.task1.repository.CarRepository;
import com.example.task1.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public Car createCar(Car car) {
        if (car.getName() == null || car.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (!manufacturerRepository.existsById(car.getManufacturer().getId())) {
            throw new IllegalArgumentException("Manufacturer does not exist");
        }
        if (carRepository.existsByNameAndManufacturerId(car.getName(), car.getManufacturer().getId())) {
            throw new IllegalArgumentException("Car name already exists for this manufacturer");
        }
        car.setCreationDate(LocalDateTime.now());
        car.setUpdateDate(LocalDateTime.now());
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car) {
        Car existing = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        existing.setName(car.getName());
        existing.setManufacturer(car.getManufacturer());
        existing.setUpdateDate(LocalDateTime.now());
        return carRepository.save(existing);
    }

    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        if (car.getAccessories() != null && !car.getAccessories().isEmpty()) {
            throw new IllegalStateException("Cannot delete car with existing accessories");
        }
        carRepository.deleteById(id);
    }

    public Car getCar(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public List<Car> getAllCars(String name, List<Long> manufacturerIds, LocalDateTime startDate, LocalDateTime endDate) {
        if (name != null) {
            return carRepository.findByNameContaining(name);
        }
        if (manufacturerIds != null && !manufacturerIds.isEmpty()) {
            return carRepository.findByManufacturerIdIn(manufacturerIds);
        }
        if (startDate != null && endDate != null) {
            return carRepository.findByCreationDateBetween(startDate, endDate);
        }
        return carRepository.findAll();
    }
}
