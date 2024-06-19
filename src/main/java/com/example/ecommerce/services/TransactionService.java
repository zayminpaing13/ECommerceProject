package com.example.ecommerce.services;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.Transaction;
import com.example.ecommerce.model.User;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public Transaction createTransaction(Transaction transaction);
    public List<Transaction> getAllTransactions();

    public List<Transaction> getTransactionsByUser(User user);
    public Optional<Transaction> getTransactionById(long id);
    public void deleteTransaction(long id);
}
