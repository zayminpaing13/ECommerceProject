package com.example.ecommerce.services;

import com.example.ecommerce.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    public Payment createPayment(Payment payment);
    public List<Payment> getAllPayments();
    public Optional<Payment> getPaymentById(long id);
    public void deletePayment(long id);
}
