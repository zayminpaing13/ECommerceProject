package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.ShippingInfo;
import com.example.ecommerce.repositories.PaymentRepository;
import com.example.ecommerce.repositories.ShippingInfoRepository;
import com.example.ecommerce.services.PaymentService;
import com.example.ecommerce.services.ShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingInfoServiceImpl implements ShippingInfoService {
    @Autowired
    ShippingInfoRepository shippingInfoRepository;

    @Override
    public ShippingInfo createShippingInfo(ShippingInfo shippingInfo) {
        return shippingInfoRepository.save(shippingInfo);
    }

    @Override
    public List<ShippingInfo> getAllShippingInfos() {
        return shippingInfoRepository.findAll();
    }

    @Override
    public Optional<ShippingInfo> getShippingInfoById(long id) {
        return shippingInfoRepository.findById(id);
    }

    @Override
    public void deleteShippingInfo(long id) {
        shippingInfoRepository.deleteById(id);
    }
}
