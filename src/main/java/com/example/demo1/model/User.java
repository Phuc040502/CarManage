package com.example.demo1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String fullname;
    private String position;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private Boolean isDeleted = false;

}
