package com.example.task1.service;

import com.example.task1.model.Category;
import com.example.task1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (categoryRepository.existsByName(category.getName())) {
            throw new IllegalArgumentException("Category name already exists");
        }
        category.setCreationDate(LocalDateTime.now());
        category.setUpdateDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category existing = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setName(category.getName());
        existing.setUpdateDate(LocalDateTime.now());
        return categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        if (category.getAccessories() != null && !category.getAccessories().isEmpty()) {
            throw new IllegalStateException("Cannot delete category with existing accessories");
        }
        categoryRepository.deleteById(id);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> getAllCategories(String name) {
        if (name != null) {
            return categoryRepository.findByNameContaining(name);
        }
        return categoryRepository.findAll();
    }
}
