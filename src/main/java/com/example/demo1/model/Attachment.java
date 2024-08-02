package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String extension;
    private String name;

    @ManyToOne
    @JoinColumn(name = "accessory_id", nullable = false)
    private Accessory accessory;


}

