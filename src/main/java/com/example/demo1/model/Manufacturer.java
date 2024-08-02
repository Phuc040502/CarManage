package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(name = "creation_Date")
    private LocalDateTime creation_Date;

    @Column(name = "update_Date")
    private LocalDateTime update_Date;

    @ManyToOne
    @JoinColumn(name = "creation_User", referencedColumnName = "username")
    private User creation_User;

    @ManyToOne
    @JoinColumn(name = "update_User", referencedColumnName = "username")
    private User update_User;

    @Column(name = "is_Deleted")
    private boolean is_Deleted = false;

    public Manufacturer() {
    }

    public Manufacturer(String name, LocalDateTime creation_Date, LocalDateTime update_Date, User creation_User, User update_User, boolean is_Deleted) {
        this.name = name;
        this.creation_Date = creation_Date;
        this.update_Date = update_Date;
        this.creation_User = creation_User;
        this.update_User = update_User;
        this.is_Deleted = is_Deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creation_Date;
    }

    public void setCreationDate(LocalDateTime creation_Date) {
        this.creation_Date = creation_Date;
    }

    public LocalDateTime getUpdateDate() {
        return update_Date;
    }

    public void setUpdateDate(LocalDateTime update_Date) {
        this.update_Date = update_Date;
    }

    public User getCreationUser() {
        return creation_User;
    }

    public void setCreationUser(User creation_User) {
        this.creation_User = creation_User;
    }

    public User getUpdateUser() {
        return update_User;
    }

    public void setUpdateUser(User update_User) {
        this.update_User = update_User;
    }

    public boolean isDeleted() {
        return is_Deleted;
    }

    public void setDeleted(boolean is_Deleted) {
        this.is_Deleted = is_Deleted;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation_Date=" + creation_Date +
                ", update_Date=" + update_Date +
                ", creation_User=" + creation_User +
                ", update_User=" + update_User +
                ", is_Deleted=" + is_Deleted +
                '}';
    }
}
