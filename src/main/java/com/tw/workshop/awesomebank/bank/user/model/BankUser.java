package com.tw.workshop.awesomebank.bank.user.model;

import com.tw.workshop.awesomebank.bank.account.model.Account;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BankUser {
    private List<Account> accounts;
    @NotNull
    private String bankUserId;
}
