package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductsByCategory(long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            return productRepository.findByCategory(category);
        } else {
            return List.of(); // Return an empty list or handle as needed
        }
    }
    @Override
    public Optional<Product> updateProduct(long id, Product product) {
        return productRepository.findById(id).map(updatedProduct -> {
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setStock(product.getStock());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setCategory(product.getCategory());
            return productRepository.save(updatedProduct);
        });
    }

    @Override
    public boolean deleteProduct(long id) {
        try{
            Optional<Product> product = productRepository.findById(id);
            if(product.isPresent()){
                productRepository.delete(product.get());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
