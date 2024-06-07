package com.example.ecommerce.services;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(long id);
    public List<Product> getProductsByCategory(long categoryId);
    public Optional<Product> updateProduct(long id, Product product);
    public boolean deleteProduct(long id);
}
