package com.example.demo1.controller;

//import com.example.demo1.repositories.CarRepository;
//import com.example.demo1.model.Car;
import com.example.demo1.model.User;
//import com.example.demo1.repositories.CarRepository;
import com.example.demo1.repositories.ManufacturerRepository;
//import com.example.demo1.model.Car;
import com.example.demo1.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

//    @Autowired
//    private CarRepository carRepository;

    @PostMapping
    public ResponseEntity<?> createManufacturer(@Validated @RequestBody Manufacturer manufacturer) {
        // Validate name
        if (manufacturerRepository.existsById(manufacturer.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manufacturer name already exists");
        }
        return ResponseEntity.ok(manufacturerRepository.save(manufacturer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateManufacturer(@PathVariable Long id, @Validated @RequestBody Manufacturer manufacturer) {
        Manufacturer existingManufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        // Validate name
        if (!existingManufacturer.getName().equals(manufacturer.getName()) &&
                manufacturerRepository.existsByName(manufacturer.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manufacturer name already exists");
        }
        existingManufacturer.setName(manufacturer.getName());
        existingManufacturer.setUpdateDate(LocalDateTime.now());
        return ResponseEntity.ok(manufacturerRepository.save(existingManufacturer));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteManufacturer(@PathVariable Long id) {
//        Manufacturer manufacturer = manufacturerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
//        CarRepository carRepository = null;
//        List<Car> cars = carRepository.findByManufacturerId(id);
//        for (Car car : cars) {
//            if (!car.getAccessories().isEmpty()) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                        .body("Cannot delete manufacturer with cars having accessories");
//            }
//            carRepository.delete(car);
//        }
//        manufacturerRepository.delete(manufacturer);
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getManufacturer(@PathVariable Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Manufacturer not found"));
        return ResponseEntity.ok(manufacturer);
    }

    @GetMapping("")
    public @ResponseBody Iterable<Manufacturer> getAllManufacturers() {
        // This returns a JSON or XML with the users
        return manufacturerRepository.findAll();
    }
}

