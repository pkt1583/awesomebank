package com.tw.workshop.awesomebank.bank.user.model;

import com.tw.workshop.awesomebank.bank.account.model.Account;
import lombok.Getter;

import java.util.UUID;

public class BankUser {
    private final String username;
    @Getter
    private final Account account = new Account();
    @Getter
    private final String bankUserId;

    public BankUser(String username) {
        this.bankUserId = UUID.randomUUID().toString();
        this.username = username;
    }

}
