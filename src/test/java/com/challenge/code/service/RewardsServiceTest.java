package com.challenge.code.service;

import com.challenge.code.util.RewardsServiceUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class RewardsServiceTest {

    private Integer customerId = 2;

    @InjectMocks
    private RewardsService rewardsService;

    @Mock
    private RewardsServiceUtils rewardsServiceUtils;

    @Test
    void getMonthlyRewardsByCustomerId() {
        Map<Integer,Long> monthlyReward = new HashMap<>();
        monthlyReward.put(12, 5310L);

        when(rewardsServiceUtils.getMonthlyRewardsByCustomerId(anyInt())).thenReturn(monthlyReward);
        String reward = rewardsService.getMonthlyRewardsByCustomerId(customerId);

        Assertions.assertEquals("In 12, this month, You earned 5310 points.\n", reward);
    }

    @Test
    void getTotalRewardsByCustomerId() {
        when(rewardsServiceUtils.getTotalRewardsByCustomerId(anyInt())).thenReturn(1234L);
        String reward = rewardsService.getTotalRewardsByCustomerId(customerId);
        Assertions.assertEquals("Your total rewards are 1234 points", reward);
    }
}