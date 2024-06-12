package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image1;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image2;
    @OneToOne
    private Category category;
}
