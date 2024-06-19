package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.PurchasedProductList;
import com.example.ecommerce.model.Transaction;
import com.example.ecommerce.model.User;
import com.example.ecommerce.model.request.PurchasedProductListReq;
import com.example.ecommerce.model.request.TransactionReq;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.TransactionService;
import com.example.ecommerce.services.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@JsonIgnoreProperties
@RequestMapping("/rest/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable Long userId){
        User user = userService.getUserById(userId);
        return transactionService.getTransactionsByUser(user);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionReq transactionReq){
        Transaction transaction = new Transaction();
        User user = userService.getUserById(transactionReq.getUserId());
        transaction.setUser(user);
        transaction.setShippingInfo(transactionReq.getShippingInfo());
        List<PurchasedProductList> purchasedProductLists = new ArrayList<>();
        PurchasedProductList purchasedProductList = new PurchasedProductList();
        for(PurchasedProductListReq purchasedProductListReq:transactionReq.getPurchasedProductListReqs()){
            Product product = productService.getProductById(purchasedProductListReq.getProductId()).get();
            purchasedProductList.setProduct(product);
            purchasedProductList.setQty(purchasedProductListReq.getQty());
            purchasedProductLists.add(purchasedProductList);
        }
        transaction.setPurchasedProductLists(purchasedProductLists);
        transaction.setPayment(transactionReq.getPayment());
        return transactionService.createTransaction(transaction);
    }
}
