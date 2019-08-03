package com.tw.workshop.awesomebank.bank.model;

import com.tw.workshop.awesomebank.bank.user.model.BankUser;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Bank {
    public Bank(String name, String code) {
        this.name = name;
        this.code = code;
        this.id = UUID.randomUUID().toString();
    }

    private String name;

    private String code;

    private String id;

    private final Map<String, BankUser> bankusers = new HashMap<>();

    public void addUserToBank(String userName) {
        BankUser createdUser = new BankUser(userName);
        this.bankusers.put(createdUser.getBankUserId(), createdUser);
    }

    public BankUser getBankUserByUserId(String userid) {
        return bankusers.get(userid);
    }

}
