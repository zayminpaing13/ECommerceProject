package com.example.ecommerce.repositories;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.PurchasedProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedProductListRepository extends JpaRepository<PurchasedProductList, Long> {
}
