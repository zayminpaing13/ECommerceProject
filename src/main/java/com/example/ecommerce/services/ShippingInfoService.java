package com.example.ecommerce.services;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.ShippingInfo;

import java.util.List;
import java.util.Optional;

public interface ShippingInfoService {
    public ShippingInfo createShippingInfo(ShippingInfo shippingInfo);
    public List<ShippingInfo> getAllShippingInfos();
    public Optional<ShippingInfo> getShippingInfoById(long id);
    public void deleteShippingInfo(long id);
}
