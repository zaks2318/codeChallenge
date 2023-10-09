package com.challenge.code.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.code.util.RewardsServiceUtils;

import java.util.Map;

@Slf4j
@Service
public class RewardsService {

    private RewardsServiceUtils rewardsServiceUtils;

    @Autowired
    public RewardsService(RewardsServiceUtils rewardsServiceUtils){
        this.rewardsServiceUtils=rewardsServiceUtils;
    }

    /*
    getMonthlyRewardsByCustomerId, this method is for getting the monthly rewards report for a customer.
    It takes an integer customer ID as an input, and return a string of the monthly reward report.
    */
    public String getMonthlyRewardsByCustomerId(Integer customerId){
        Map<Integer,Long> rewards =  rewardsServiceUtils.getMonthlyRewardsByCustomerId(customerId);
        log.info("RewardsService--getMonthlyRewardsByCustomerId rewards months: " + rewards.size());
        StringBuilder report = new StringBuilder();
        for (Map.Entry<Integer, Long> e: rewards.entrySet()) {
            report.append("In "+ e.getKey() + ", this month," + " You earned " + e.getValue()+" points.\n");
        }
        return report.toString();
    }

    /*
    getTotalRewardsByCustomerId, this method is for getting the total rewards report for a customer.
    It takes an integer customer ID as an input, and return a string of the total reward report.
    */
    public String getTotalRewardsByCustomerId(Integer customerId){
        Long report = rewardsServiceUtils.getTotalRewardsByCustomerId(customerId);
        return "Your total rewards are " + report+ " points";
    }
}
