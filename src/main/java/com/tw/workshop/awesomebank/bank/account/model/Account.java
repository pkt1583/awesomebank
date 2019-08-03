package com.tw.workshop.awesomebank.bank.account.model;

import com.tw.workshop.awesomebank.bank.account.exception.InsufficientFundsException;
import com.tw.workshop.awesomebank.bank.account.exception.InvalidTransaction;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.tw.workshop.awesomebank.bank.account.model.TransactionType.CREDIT;
import static com.tw.workshop.awesomebank.bank.account.model.TransactionType.DEBIT;

public class Account {
    @Getter
    private String accountId;
    @Getter
    private long currentBalance;
    @Getter
    private List<Transaction> transactions = new LinkedList<>();

    public Account() {
        this.accountId = UUID.randomUUID().toString();
        this.currentBalance = 0;
    }

    public void performCredit(long transactionAmount) {
        Transaction transaction = createTransaction(CREDIT, transactionAmount);
        long balance = transaction.transactionType.perform(currentBalance, transactionAmount);
        this.transactions.add(transaction);
    }

    public void performDebit(long transactionAmount) {
        Transaction transaction = createTransaction(DEBIT, transactionAmount);
        long balance = transaction.transactionType.perform(currentBalance, transactionAmount);
        if (balance < 0) {
            throw new InsufficientFundsException("Insufficient balance in account " + accountId + " Requested Amount: " + transactionAmount);
        }
        this.transactions.add(transaction);
    }

    private Transaction createTransaction(TransactionType transactionType, long transactionAmount) {
        if (transactionAmount < 0) {
            throw new InvalidTransaction("Amount " + transactionAmount + " is negative amount");
        }
        return new Transaction(transactionType, transactionAmount);
    }

    private static class Transaction {
        @Getter
        private String transactionId;
        @NotNull
        private TransactionType transactionType;
        @NotNull
        private long transactionAmount;

        private Transaction(TransactionType transactionType, long transactionAmount) {
            this.transactionAmount = transactionAmount;
            this.transactionType = transactionType;
            this.transactionId = UUID.randomUUID().toString();
        }

    }

}
