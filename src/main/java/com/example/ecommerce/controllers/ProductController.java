package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.request.ProductReq;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.S3Service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@JsonIgnoreProperties
@RequestMapping("/rest/products")
public class ProductController {

    @Autowired
    S3Service s3Service;

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


    @PostMapping("/save")
    public Product saveProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("stock") int stock,
            @RequestParam("categoryId") long categoryId,
            @RequestParam("image1") MultipartFile image1,
            @RequestParam("image2") MultipartFile image2) {

        Category category = categoryService.getCategoryById(categoryId).get();
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setCategory(category);

        try {
            if (!image1.isEmpty()) {
                String url = s3Service.uploadFile(image1);
                product.setImage1(url);
            }
            if (!image2.isEmpty()) {
                String url = s3Service.uploadFile(image2);
                product.setImage2(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productService.createProduct(product);
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
