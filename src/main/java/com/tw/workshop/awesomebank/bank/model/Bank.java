package com.tw.workshop.awesomebank.bank.model;

import com.tw.workshop.awesomebank.bank.account.model.Account;
import com.tw.workshop.awesomebank.bank.user.model.BankUser;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Bank {
    @NotNull
    private String name;
    @NotNull
    private String code;
    private List<BankUser> accounts;
}
