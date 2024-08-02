package com.example.task1.controller;

import com.example.task1.model.Accessory;
import com.example.task1.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessories")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @PostMapping
    public ResponseEntity<Accessory> createAccessory(@RequestBody Accessory accessory) {
        return new ResponseEntity<>(accessoryService.createAccessory(accessory), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accessory> updateAccessory(@PathVariable Long id, @RequestBody Accessory accessory) {
        return ResponseEntity.ok(accessoryService.updateAccessory(id, accessory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccessory(@PathVariable Long id) {
        accessoryService.deleteAccessory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accessory> getAccessory(@PathVariable Long id) {
        return ResponseEntity.ok(accessoryService.getAccessory(id));
    }

    @GetMapping
    public ResponseEntity<List<Accessory>> getAllAccessories(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) List<Long> categoryIds,
            @RequestParam(required = false) List<Long> manufacturerIds) {
        return ResponseEntity.ok(accessoryService.getAllAccessories(name, description, minPrice, maxPrice, categoryIds, manufacturerIds));
    }
}

