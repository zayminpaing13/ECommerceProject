package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String emailAddress;
    private String region;
    private String name;
    private String address;
    private String apartment;
    private String city;
    private String postalCode;
    private String phoneNumber;
//    @OneToOne(mappedBy = "shippingInfo", cascade = CascadeType.ALL)
//    private Transaction transaction;
}
