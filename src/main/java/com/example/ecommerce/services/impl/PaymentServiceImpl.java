package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.repositories.PaymentRepository;
import com.example.ecommerce.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void deletePayment(long id) {
        paymentRepository.deleteById(id);
    }
}
