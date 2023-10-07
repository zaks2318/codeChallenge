package com.challenge.code.controller;

import com.challenge.code.exception.ServiceException;
import com.challenge.code.service.RewardsService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class RewardsControllerTest {

    private Integer customerId = 1;
    private Integer notExistCustomerId = 4;

    @InjectMocks
    private RewardsController rewardsController;

    @Mock
    RewardsService rewardsService;

    @Test
    void getMonthlyRewardReport() throws ServiceException {
        when(rewardsService.getMonthlyRewardsByCustomerId(anyInt())).thenReturn("In this month you earn some points.");

        ResponseEntity response = rewardsController.getMonthlyRewardReport(customerId);

        Assertions.assertNotNull(customerId);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getMonthlyRewardReportFail(){
        when(rewardsService.getMonthlyRewardsByCustomerId(anyInt())).thenReturn("");

        Assertions.assertThrows(ServiceException.class, () -> {
            rewardsController.getMonthlyRewardReport(notExistCustomerId);
        });
    }

    @Test
    void getTotalRewardReport() throws ServiceException {
        when(rewardsService.getTotalRewardsByCustomerId(anyInt())).thenReturn("Your total rewards are some points.");

        ResponseEntity response = rewardsController.getTotalRewardReport(customerId);

        Assertions.assertNotNull(customerId);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getTotalRewardReportFail(){
        when(rewardsService.getTotalRewardsByCustomerId(anyInt())).thenReturn("");

        Assertions.assertThrows(ServiceException.class, () -> {
            rewardsController.getTotalRewardReport(notExistCustomerId);
                });
    }
}