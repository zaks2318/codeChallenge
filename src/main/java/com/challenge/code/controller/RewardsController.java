package com.challenge.code.controller;

import com.challenge.code.exception.ServiceException;
import com.challenge.code.service.RewardsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RewardsController {

    private final RewardsService rewardsService;

    @Autowired
    public RewardsController(RewardsService rewardsService){
        this.rewardsService = rewardsService;
    }

    @GetMapping("/monthly-rewards/customers/{customerId}")
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

    @GetMapping("/total-rewards/customers/{customerId}")
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
