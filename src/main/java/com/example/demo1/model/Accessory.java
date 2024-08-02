//package com.example.demo1.model;
//
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import jdk.jfr.Category;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//@Entity
//public class Accessory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    @Size(max = 100)
//    private String code;
//
//    @NotBlank
//    @Size(max = 100)
//    private String name;
//
//    private String description;
//    private double price;
//
//    private LocalDateTime creationDate;
//    private LocalDateTime updateDate;
//
//    @ManyToOne
//    @JoinColumn(name = "manufacturer_id")
//    private Manufacturer manufacturer;
//
//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category; // Ensure this targets your own Category entity
//
//    @ManyToOne
//    @JoinColumn(name = "creation_user_id")
//    private User creationUser;
//
//    @ManyToOne
//    @JoinColumn(name = "update_user_id")
//    private User updateUser;
//
////    @OneToMany(mappedBy = "accessory", cascade = CascadeType.ALL, orphanRemoval = true)
////    private List<Attachment> attachments;
//
//    private boolean isDeleted = false;
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public @NotBlank @Size(max = 100) String getCode() {
//        return code;
//    }
//
//    public void setCode(@NotBlank @Size(max = 100) String code) {
//        this.code = code;
//    }
//
//    public @NotBlank @Size(max = 100) String getName() {
//        return name;
//    }
//
//    public void setName(@NotBlank @Size(max = 100) String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public LocalDateTime getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(LocalDateTime creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public LocalDateTime getUpdateDate() {
//        return updateDate;
//    }
//
//    public void setUpdateDate(LocalDateTime updateDate) {
//        this.updateDate = updateDate;
//    }
//
//    public Manufacturer getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(Manufacturer manufacturer) {
//        this.manufacturer = manufacturer;
//    }
//
//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public User getCreationUser() {
//        return creationUser;
//    }
//
//    public void setCreationUser(User creationUser) {
//        this.creationUser = creationUser;
//    }
//
//    public User getUpdateUser() {
//        return updateUser;
//    }
//
//    public void setUpdateUser(User updateUser) {
//        this.updateUser = updateUser;
//    }
//
////    public List<Attachment> getAttachments() {
////        return attachments;
////    }
////
////    public void setAttachments(List<Attachment> attachments) {
////        this.attachments = attachments;
////    }
//
//    public boolean isDeleted() {
//        return isDeleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        isDeleted = deleted;
//    }
//}
//
//
