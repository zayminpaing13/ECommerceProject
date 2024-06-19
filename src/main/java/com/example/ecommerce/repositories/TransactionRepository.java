package com.example.ecommerce.repositories;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.Transaction;
import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByUser(User user);
}
