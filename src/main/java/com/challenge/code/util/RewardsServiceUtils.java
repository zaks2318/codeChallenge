package com.challenge.code.util;

import com.challenge.code.model.Transaction;
import com.challenge.code.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class RewardsServiceUtils {

    private static final int RewardLevelOne = 50;
    private static final int RewardLevelTwo = 100;

    @Autowired
    TransactionRepository transactionRepository;

    public Map<Integer,Long> getMonthlyRewardsByCustomerId(Integer customerId){
        List<Transaction> allTransactions = transactionRepository.getAllCustomersTransByCustomerId(customerId);
        log.info("RewardsServiceUtils--getMonthlyRewardsByCustomerId Transaction size " + allTransactions.size());
        Map<Integer,Long> monthlyReward = new HashMap<>();
        for (Transaction t : allTransactions) {
            if (monthlyReward.containsKey(t.getMonth())){
                monthlyReward.put(t.getMonth(),monthlyReward.get(t.getMonth())+calculateReward(t.getAmount()));
            }else {
                monthlyReward.put(t.getMonth(),calculateReward(t.getAmount()));
            }
        }
        return monthlyReward;
    }

    private Long calculateReward(Double amount){
        if (amount>RewardLevelOne && amount >RewardLevelTwo){
            return Math.round((amount-RewardLevelOne) + (amount-RewardLevelTwo));
        } else if (amount>RewardLevelOne) {
            return Math.round(amount-RewardLevelOne);
        }else {
            return 0L;
        }
    }

    public Long getTotalRewardsByCustomerId(Integer customerId){
        List<Transaction> allTransactions = transactionRepository.getAllCustomersTransByCustomerId(customerId);
        log.info("RewardsServiceUtils--getTotalRewardsByCustomerId Transaction size " + allTransactions.size());
        Long totalRewards = 0L;
        for (Transaction t : allTransactions) {
            totalRewards += calculateReward(t.getAmount());
        }
        return totalRewards;
    }
}
