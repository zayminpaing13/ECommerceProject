package com.example.ecommerce.model.dto;

import com.example.ecommerce.model.Category;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdate {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private MultipartFile image1;
    private MultipartFile image2;
    private Long categoryId;
}
