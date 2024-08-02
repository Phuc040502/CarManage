package com.example.task1.controller;

import com.example.task1.model.Manufacturer;
import com.example.task1.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
        return new ResponseEntity<>(manufacturerService.createManufacturer(manufacturer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable Long id, @RequestBody Manufacturer manufacturer) {
        return ResponseEntity.ok(manufacturerService.updateManufacturer(id, manufacturer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable Long id) {
        return ResponseEntity.ok(manufacturerService.getManufacturer(id));
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(manufacturerService.getAllManufacturers(name));
    }
}


