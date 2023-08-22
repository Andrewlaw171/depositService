package com.example.depositService.controllers;

import com.example.depositService.api.TermDepositResponse;
import com.example.depositService.model.TermDeposit;
import com.example.depositService.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit-calculator")
public class DepositServiceController {
    private final DepositService depositService;

    public DepositServiceController(@Autowired DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/final-balance")
    public TermDepositResponse getFinalBalance(@RequestBody TermDeposit termDeposit) {
        int finalBalance = depositService.calculateTermDepositFinalBalance(termDeposit);
        return new TermDepositResponse.Builder().finalBalance(finalBalance).build();
    }
}
