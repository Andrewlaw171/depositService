package com.example.depositService.services;

import com.example.depositService.model.TermDeposit;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    public int calculateTermDepositFinalBalance(TermDeposit termDeposit) {
        double compoundsPerYear = 0.0;
        switch(termDeposit.getInterestType()) {
            case MONTHLY -> compoundsPerYear = 12.0;
            case QUARTERLY -> compoundsPerYear = 4.0;
            case ANNUALLY -> compoundsPerYear = 1.0;
            case MATURITY -> compoundsPerYear = 0.0;
        }
        return (int) Math.round(calculateInterest(termDeposit, compoundsPerYear));
    }

    private double calculateInterest(TermDeposit termDeposit, double compoundsPerYear) {
        int principal = termDeposit.getStartDeposit();
        double rate = termDeposit.getInterestRatePerAnnum();
        double timeYears = termDeposit.getInvestmentTermMonths() / 12.0;

        if (compoundsPerYear == 0.0) {
            return principal * (1 + rate * timeYears);
        }
        return principal * Math.pow(1 + rate/compoundsPerYear, (compoundsPerYear*timeYears));
    }
}
