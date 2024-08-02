package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "User")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(length = 255)
    private String username;
    private String password;
    private String fullname;
    private String position;
    private LocalDateTime creation_date ;
    private LocalDateTime update_date;
    private boolean is_deleled;

    public User(int id, String username, String password, String fullname, String position, LocalDateTime update_date, LocalDateTime creation_date, boolean is_deleled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.position = position;
        this.update_date = update_date;
        this.creation_date= creation_date;
        this.is_deleled = is_deleled;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public boolean isIs_deleled() {
        return is_deleled;
    }

    public void setIs_deleled(boolean is_deleled) {
        this.is_deleled = is_deleled;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", position='" + position + '\'' +
                ", creation_date=" + creation_date +
                ", update_date=" + update_date +
                ", is_deleled=" + is_deleled +
                '}';
    }
}