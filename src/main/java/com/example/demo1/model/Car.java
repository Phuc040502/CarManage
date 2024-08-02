//package com.example.demo1.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//
//
//@Entity
//public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    @Size(max = 100)
//    @Column(unique = true)
//    private String name;
//
//    private LocalDateTime creationDate;
//    private LocalDateTime updateDate;
//
//    @ManyToOne
//    @JoinColumn(name = "manufacturer_id")
//    private Manufacturer manufacturer;
//
//    @ManyToOne
//    @JoinColumn(name = "creation_user_id")
//    private User creationUser;
//
//    @ManyToOne
//    @JoinColumn(name = "update_user_id")
//    private User updateUser;
//
//    @ManyToMany(mappedBy = "cars")
//    private List<Accessory> accessories;
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
//    public @NotBlank @Size(max = 100) String getName() {
//        return name;
//    }
//
//    public void setName(@NotBlank @Size(max = 100) String name) {
//        this.name = name;
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
//    public boolean isDeleted() {
//        return isDeleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        isDeleted = deleted;
//    }
//
//    public List<Accessory> getAccessories() {
//        return accessories;
//    }
//
//    public void setAccessories(List<Accessory> accessories) {
//        this.accessories = accessories;
//    }
//}
