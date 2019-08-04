package com.tw.workshop.awesomebank.user.model;

import com.tw.workshop.awesomebank.account.model.Account;
import com.tw.workshop.awesomebank.user.AwesomeUser;
import lombok.Getter;

public class BankUser {
    @Getter
    private final AwesomeUser user;
    @Getter
    private final Account account = new Account();
    @Getter
    private final String bankUserId;

    public BankUser(final AwesomeUser user, final String bankUserId) {
        this.bankUserId = bankUserId;
        this.user = user;
    }

}
