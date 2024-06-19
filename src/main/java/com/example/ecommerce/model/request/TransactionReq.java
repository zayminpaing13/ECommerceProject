package com.example.ecommerce.model.request;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.PurchasedProductList;
import com.example.ecommerce.model.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionReq {
    private long userId;
    private ShippingInfo shippingInfo;
    private List<PurchasedProductListReq> purchasedProductListReqs;
    private Payment payment;
}
