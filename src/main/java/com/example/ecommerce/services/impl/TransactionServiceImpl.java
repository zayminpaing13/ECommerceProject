package com.example.ecommerce.services.impl;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.Transaction;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repositories.PaymentRepository;
import com.example.ecommerce.repositories.TransactionRepository;
import com.example.ecommerce.services.PaymentService;
import com.example.ecommerce.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findTransactionsByUser(user);
    }

    @Override
    public Optional<Transaction> getTransactionById(long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }
}
