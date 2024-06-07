package com.example.ecommerce.model.request;

import com.example.ecommerce.model.Category;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReq {
    private String name;
    private String description;
    private double price;
    private int stock;
    private long categoryId;
}
