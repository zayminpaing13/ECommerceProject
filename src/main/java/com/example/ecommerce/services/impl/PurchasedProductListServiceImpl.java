package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.PurchasedProductList;
import com.example.ecommerce.repositories.PaymentRepository;
import com.example.ecommerce.repositories.PurchasedProductListRepository;
import com.example.ecommerce.services.PaymentService;
import com.example.ecommerce.services.PurchasedProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchasedProductListServiceImpl implements PurchasedProductListService {
    @Autowired
    PurchasedProductListRepository purchasedProductListRepository;

    @Override
    public PurchasedProductList createPurchasedProductList(PurchasedProductList purchasedProductList) {
        return purchasedProductListRepository.save(purchasedProductList);
    }

    @Override
    public List<PurchasedProductList> getAllPurchasedProductList() {
        return purchasedProductListRepository.findAll();
    }

    @Override
    public Optional<PurchasedProductList> getPurchasedProductListById(long id) {
        return purchasedProductListRepository.findById(id);
    }

    @Override
    public void deletePurchasedProductList(long id) {
        purchasedProductListRepository.deleteById(id);
    }
}
