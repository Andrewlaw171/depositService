package com.example.depositService.api;

public class TermDepositResponse {

    private int finalBalance;

    private TermDepositResponse(int finalBalance) {
        this.finalBalance = finalBalance;
    }

    public int getFinalBalance() {
        return finalBalance;
    }

    public static final class Builder {
        private int finalBalance;

        public Builder(){
        }

        public Builder finalBalance(int finalBalance) {
            this.finalBalance = finalBalance;
            return this;
        }

        public TermDepositResponse build() {
            return new TermDepositResponse(finalBalance);
        }
    }
}
