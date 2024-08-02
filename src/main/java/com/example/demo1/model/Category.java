package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private boolean isDeleted;

    @ManyToMany(mappedBy = "category")
    private Set<Accessory> accessories;


}

