package com.challenge.code.repository;

import com.challenge.code.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> getAllCustomersTransByCustomerId(Integer customerId);
}
