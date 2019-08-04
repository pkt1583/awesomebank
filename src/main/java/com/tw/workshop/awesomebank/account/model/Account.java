package com.tw.workshop.awesomebank.account.model;

import com.tw.workshop.awesomebank.account.exception.InsufficientFundsException;
import com.tw.workshop.awesomebank.account.exception.InvalidTransactionException;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.tw.workshop.awesomebank.account.model.TransactionType.CREDIT;
import static com.tw.workshop.awesomebank.account.model.TransactionType.DEBIT;

public class Account {
    @Getter
    private final String accountId = UUID.randomUUID().toString();
    private final List<Transaction> transactions = new LinkedList<>();
    @Getter
    private long currentBalance;

    public Account() {
        this.currentBalance = 0;
    }

    public Account(final long initialAmount) {
        super();
        this.currentBalance = initialAmount;
    }

    private static Transaction createTransaction(final TransactionType transactionType, final long transactionAmount) {
        if (transactionAmount < 0) {
            throw new InvalidTransactionException("Amount " + transactionAmount + " is negative amount");
        }
        return new Transaction(transactionType, transactionAmount);
    }

    public synchronized void performCredit(final long transactionAmount) {
        final Transaction transaction = createTransaction(CREDIT, transactionAmount);
        final long balance = transaction.transactionType.perform(currentBalance, transactionAmount);
        this.transactions.add(transaction);
        this.currentBalance = balance;
    }

    public synchronized void performDebit(final long transactionAmount) {
        final Transaction transaction = createTransaction(DEBIT, transactionAmount);
        final long balance = transaction.transactionType.perform(currentBalance, transactionAmount);
        if (balance < 0) {
            throw new InsufficientFundsException("Insufficient balance in account " + accountId + " Requested Amount: " + transactionAmount);
        }
        this.transactions.add(transaction);
        this.currentBalance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions.stream().map(transaction -> new Transaction(transaction.transactionType, transaction.transactionAmount, transaction.transactionId)).collect(Collectors.toList());
    }

    public static class Transaction {
        @Getter
        private final long transactionAmount;
        @NotNull
        @Getter
        private final TransactionType transactionType;
        @Getter
        private String transactionId = UUID.randomUUID().toString();

        private Transaction(final TransactionType transactionType, final long transactionAmount) {
            this.transactionAmount = transactionAmount;
            this.transactionType = transactionType;
        }

        public Transaction(final TransactionType transactionType, final long transactionAmount, final String transactionId) {
            this(transactionType, transactionAmount);
            this.transactionId = transactionId;
        }
    }

}
