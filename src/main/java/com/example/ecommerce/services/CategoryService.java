package com.example.ecommerce.services;

import com.example.ecommerce.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category createCategory(Category category);
    public List<Category> getAllCategories();
    public Optional<Category> getCategoryById(long id);
    public Optional<Category> updateCategory(long id, Category category);
    public boolean deleteCategory(long id);
}
