package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> updateCategory(long id, Category category) {
        return categoryRepository.findById(id).map(updatedCategory -> {
            updatedCategory.setName(category.getName());
            updatedCategory.setDescription(category.getDescription());
            return categoryRepository.save(updatedCategory);
        });
    }

    @Override
    public boolean deleteCategory(long id) {
        try{
            Optional<Category> category = categoryRepository.findById(id);
            if(category.isPresent()){
                categoryRepository.delete(category.get());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
