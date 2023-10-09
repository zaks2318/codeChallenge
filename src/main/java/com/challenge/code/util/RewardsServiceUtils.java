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

    /*
    getMonthlyRewardsByCustomerId, this method is for mapping the transactions to month and monthly rewards for a customer.
    It takes an integer customer ID as an input, and return a map which the key will be the month and value will be the rewards.
    */
    public Map<Integer,Long> getMonthlyRewardsByCustomerId(Integer customerId){
        List<Transaction> allTransactions = transactionRepository.getAllCustomersTransByCustomerId(customerId);
        log.info("RewardsServiceUtils--getMonthlyRewardsByCustomerId Transaction size " + allTransactions.size());

        // mapping transactions to different month and monthly rewards.
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

    /*
    calculateReward, this is a method that calculate the rewards base on the transaction amount.
    It takes the amount of a transaction as an input, and it will return a long number which is the rewards.
    * */
    protected Long calculateReward(Double amount){
        if (amount>RewardLevelOne && amount >RewardLevelTwo){
            //calculate for amount over $100
            return Math.round((amount-RewardLevelOne) + (amount-RewardLevelTwo));
        } else if (amount>RewardLevelOne) {
            //calculate for amount over $50
            return Math.round(amount-RewardLevelOne);
        }else {
            return 0L;
        }
    }

    /*
    getTotalRewardsByCustomerId, this method is for getting the transactions and calculate the total rewards for a customer.
    It takes an integer customer ID as an input, and return long number that is the total reward for that customer.
    */
    public Long getTotalRewardsByCustomerId(Integer customerId){
        List<Transaction> allTransactions = transactionRepository.getAllCustomersTransByCustomerId(customerId);
        log.info("RewardsServiceUtils--getTotalRewardsByCustomerId Transaction size " + allTransactions.size());

        // add up all the rewards points
        Long totalRewards = 0L;
        for (Transaction t : allTransactions) {
            totalRewards += calculateReward(t.getAmount());
        }
        return totalRewards;
    }
}
