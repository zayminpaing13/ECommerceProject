package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.services.CategoryService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@JsonIgnoreProperties
@RequestMapping("/rest/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Optional<Category> opt_category = categoryService.getCategoryById(id);
        Category category = opt_category.get();
        if(categoryDetails.getName()!=null){
            category.setName(categoryDetails.getName());
        }
        if(categoryDetails.getDescription()!=null){
            category.setDescription(categoryDetails.getDescription());
        }
        categoryRepository.save(category);
        return opt_category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean isDeleted = categoryService.deleteCategory(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
