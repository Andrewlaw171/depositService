package com.example.depositService.services;

import com.example.depositService.model.InterestType;
import com.example.depositService.model.TermDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepositServiceTest {
    private final DepositService depositService = new DepositService();

    @Test
    public void itShouldCalculateCorrectSimpleInterest() {
        TermDeposit termDeposit = new TermDeposit.Builder()
                .startDeposit(10000)
                .investmentTermMonths(36)
                .interestRatePerAnnum(0.011)
                .interestType(InterestType.MATURITY)
                .build();
        Assertions.assertEquals(10330, depositService.calculateTermDepositFinalBalance(termDeposit));
    }

    @Test
    public void itShouldCalculateCorrectCompoundInterest() {
        TermDeposit termDeposit = new TermDeposit.Builder()
                .startDeposit(10000)
                .investmentTermMonths(36)
                .interestRatePerAnnum(0.011)
                .interestType(InterestType.MONTHLY)
                .build();
        Assertions.assertEquals(10335, depositService.calculateTermDepositFinalBalance(termDeposit));
    }

    @Test
    public void itShouldHandleLessThanAYearSimpleInterest() {
        TermDeposit termDeposit = new TermDeposit.Builder()
                .startDeposit(10000)
                .investmentTermMonths(8)
                .interestRatePerAnnum(0.064)
                .interestType(InterestType.MATURITY)
                .build();
        Assertions.assertEquals(10427, depositService.calculateTermDepositFinalBalance(termDeposit));
    }

    @Test
    public void itShouldHandleLessThanAYearCompoundInterest() {
        TermDeposit termDeposit = new TermDeposit.Builder()
                .startDeposit(10000)
                .investmentTermMonths(8)
                .interestRatePerAnnum(0.064)
                .interestType(InterestType.MONTHLY)
                .build();
        Assertions.assertEquals(10435, depositService.calculateTermDepositFinalBalance(termDeposit));
    }
}
