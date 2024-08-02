//package com.example.demo1.service;
//
////import com.example.demo1.model.Car;
//import com.example.demo1.model.Car;
//import com.example.demo1.model.Manufacturer;
////import com.example.demo1.repositories.CarRepository;
//import com.example.demo1.repositories.CarRepository;
//import com.example.demo1.repositories.ManufacturerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class ManufacturerService {
//
//    @Autowired
//    private ManufacturerRepository manufacturerRepository;
//
////    @Autowired
////    private CarRepository carRepository;
//
//    @Transactional
//    public Manufacturer createManufacturer(Manufacturer manufacturer) {
//        manufacturer.setCreationDate(LocalDateTime.now());
//        manufacturer.setUpdateDate(LocalDateTime.now());
//        return manufacturerRepository.save(manufacturer);
//    }
//
//    @Transactional
//    public Manufacturer updateManufacturer(Long id, Manufacturer manufacturerDetails) {
//        Manufacturer manufacturer = manufacturerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
//        manufacturer.setName(manufacturerDetails.getName());
//        manufacturer.setUpdateDate(LocalDateTime.now());
//        return manufacturerRepository.save(manufacturer);
//    }
//
//    @Transactional
//    public void deleteManufacturer(Long id) {
//        Manufacturer manufacturer = manufacturerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
//        CarRepository carRepository = null;
//        List<Car> cars = carRepository.findByManufacturerId(id);
//        for (Car car : cars) {
//            if (!car.getAccessories().isEmpty()) {
//                throw new IllegalArgumentException("Cannot delete manufacturer with cars having accessories");
//            }
//            carRepository.delete(car);
//        }
//        manufacturerRepository.delete(manufacturer);
//    }
//
//    public Manufacturer getManufacturer(Long id) {
//        return manufacturerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
//    }
//
//    public List<Manufacturer> getAllManufacturers() {
//        return manufacturerRepository.findAll();
//    }
//}
//
