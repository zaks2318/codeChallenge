package com.challenge.code.util;

import com.challenge.code.model.Transaction;
import com.challenge.code.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RewardsServiceUtilsTest {

    private int RewardLevelOne = 50;

    private int RewardLevelTwo = 100;

    private Integer customerId = 3;

    @InjectMocks
    private RewardsServiceUtils rewardsServiceUtils;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    void getMonthlyRewardsByCustomerId() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(12);
        transaction.setCustomerId(3);
        transaction.setYear(2323);
        transaction.setMonth(9);
        transaction.setDay(10);
        transaction.setAmount(12.23);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

        Map<Integer,Long> monthlyReward = new HashMap<>();
        monthlyReward.put(9, 0L);

        when(transactionRepository.getAllCustomersTransByCustomerId(anyInt())).thenReturn(transactionList);
        Map<Integer,Long> monthlyReward1 = rewardsServiceUtils.getMonthlyRewardsByCustomerId(customerId);

        Assertions.assertEquals(monthlyReward, monthlyReward1);
    }

    @Test
    void calculateRewardTwoLevels() {
        Long roundAmount = (long) Math.round((150-RewardLevelOne) + (150-RewardLevelTwo));
        Long result = rewardsServiceUtils.calculateReward(150.0);

        Assertions.assertEquals(roundAmount, result);
    }

    @Test
    void calculateRewardLevelOne() {
        Long roundAmount = (long) Math.round(60-RewardLevelOne);
        Long result = rewardsServiceUtils.calculateReward(60.0);

        Assertions.assertEquals(roundAmount, result);
    }

    @Test
    void getTotalRewardsByCustomerId() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(12);
        transaction.setCustomerId(3);
        transaction.setYear(2323);
        transaction.setMonth(9);
        transaction.setDay(10);
        transaction.setAmount(12.23);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

        when(transactionRepository.getAllCustomersTransByCustomerId(anyInt())).thenReturn(transactionList);
        Long totalRewards = rewardsServiceUtils.getTotalRewardsByCustomerId(customerId);

        Assertions.assertEquals(0L, totalRewards);
    }
}