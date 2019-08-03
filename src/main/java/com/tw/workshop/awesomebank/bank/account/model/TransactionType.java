package com.tw.workshop.awesomebank.bank.account.model;

public enum TransactionType {
    CREDIT(-1), DEBIT(1);
    private int multiplier;

    TransactionType(int multiplier) {
        this.multiplier = multiplier;
    }

    public long perform(long initialBalance, long currentTransactedAmount) {
        return initialBalance - currentTransactedAmount * multiplier;
    }
}
