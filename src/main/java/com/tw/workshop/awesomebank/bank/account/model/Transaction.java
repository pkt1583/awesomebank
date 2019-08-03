package com.tw.workshop.awesomebank.bank.account.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Transaction {
    @NotNull
    private String transactionId;
    @NotNull
    private TransactionType transactionType;
    @NotNull
    private long transactionAmount;
    private long balance;

    @Valid()
    public void setTransactionAmount(long transactionAmount) {

        this.transactionAmount = transactionAmount;
        this.balance = this.balance - transactionAmount;
    }
}
