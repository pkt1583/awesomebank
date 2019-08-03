package com.tw.workshop.awesomebank.bank.account.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Account {
    @NotNull
    private String accountId;
    private Long currentBalance;
    private List<Transaction> transactions;
}
