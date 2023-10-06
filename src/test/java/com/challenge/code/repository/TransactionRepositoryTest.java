package com.challenge.code.repository;

import com.challenge.code.model.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {

    private Integer customerId = 2;

    @InjectMocks
    private TransactionRepository transactionRepository;

    @Test
    void getAllCustomersTransByCustomerId() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(12);
        transaction.setCustomerId(3);
        transaction.setYear(2323);
        transaction.setMonth(9);
        transaction.setDay(10);
        transaction.setAmount(12.23);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

    }
}