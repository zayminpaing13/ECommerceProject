package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.request.ProductReq;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@JsonIgnoreProperties
@RequestMapping("/rest/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable Long id) {
        List<Product> products = productService.getProductsByCategory(id);
        return products;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductReq productReq) {
        Category category = categoryService.getCategoryById(productReq.getCategoryId()).get();
        Product product = new Product();
        product.setName(productReq.getName());
        product.setDescription(productReq.getDescription());
        product.setCategory(category);
        product.setStock(productReq.getStock());
        product.setPrice(productReq.getPrice());
        product.setStock(productReq.getStock());
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductReq productReq) {
        Category category = categoryService.getCategoryById(productReq.getCategoryId()).get();
        Product product = new Product();
        product.setCategory(category);
        product.setStock(productReq.getStock());
        product.setPrice(productReq.getPrice());
        product.setName(productReq.getName());
        product.setDescription(productReq.getDescription());
        Optional<Product> updateProduct = productService.updateProduct(id, product);
        return updateProduct.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
