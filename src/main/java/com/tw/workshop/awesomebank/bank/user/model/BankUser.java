package com.tw.workshop.awesomebank.bank.user.model;

import com.tw.workshop.awesomebank.bank.account.model.Account;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class BankUser {
    private final String username;

    public BankUser(String username) {
        this.bankUserId = UUID.randomUUID().toString();
        this.username = username;
    }

    @Getter
    private final Account account = new Account();

    @Getter
    private final String bankUserId;

}
