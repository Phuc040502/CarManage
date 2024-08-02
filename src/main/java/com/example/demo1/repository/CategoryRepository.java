package com.example.demo1.repository;

import com.example.task1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
    boolean existsById(Long id);
    List<Category> findByNameContaining(String name);
}


