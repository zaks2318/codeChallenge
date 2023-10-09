package com.challenge.code.controller;

import com.challenge.code.exception.ServiceException;
import com.challenge.code.service.RewardsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/customers")
public class RewardsController {

    private final RewardsService rewardsService;

    @Autowired
    public RewardsController(RewardsService rewardsService){
        this.rewardsService = rewardsService;
    }

    /*
    This endpoint is for getting the monthly rewards report for a customer.
    It takes an integer which is the customer ID as an input.
    It returns a response with a report with month and monthly rewards.
    */
    @GetMapping("/{customerId}/monthly-rewards")
    public ResponseEntity getMonthlyRewardReport(@PathVariable Integer customerId) throws ServiceException{

        long start = System.nanoTime();
        log.info("/MonthlyRewards--getMonthlyRewardReport start time: "+ start);
        String report = rewardsService.getMonthlyRewardsByCustomerId(customerId);

        if (report.isEmpty()){
            throw new ServiceException("No reward is found!");
        }
        long end = System.nanoTime();
        log.info("/MonthlyRewards--getMonthlyRewardReport end time: "+ end);
        log.info("/MonthlyRewards--getMonthlyRewardReport time taken: "+ (end - start));

        return ResponseEntity.ok().body(report);
    }

    /*
    This endpoint is for getting the total rewards report for a customer.
    It takes an integer which is the customer ID as an input.
    It returns a response with a report with total rewards points for that customer.
    */
    @GetMapping("/{customerId}/total-rewards")
    public ResponseEntity getTotalRewardReport(@PathVariable Integer customerId) throws ServiceException{

        long start = System.nanoTime();
        log.info("/TotalRewards--getTotalRewardReport start time: "+ start);
        String report = rewardsService.getTotalRewardsByCustomerId(customerId);

        if (report.isEmpty()){
            throw new ServiceException("No reward is found!");
        }
        long end = System.nanoTime();
        log.info("/TotalRewards--getTotalRewardReport end time: "+ end);
        log.info("/TotalRewards--getTotalRewardReport time taken: "+ (end - start));

        return ResponseEntity.ok().body(report);
    }

}
