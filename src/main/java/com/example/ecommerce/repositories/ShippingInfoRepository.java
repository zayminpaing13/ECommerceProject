package com.example.ecommerce.repositories;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {
}
