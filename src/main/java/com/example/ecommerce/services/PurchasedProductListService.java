package com.example.ecommerce.services;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.PurchasedProductList;

import java.util.List;
import java.util.Optional;

public interface PurchasedProductListService {
    public PurchasedProductList createPurchasedProductList(PurchasedProductList purchasedProductList);
    public List<PurchasedProductList> getAllPurchasedProductList();
    public Optional<PurchasedProductList> getPurchasedProductListById(long id);
    public void deletePurchasedProductList(long id);
}
