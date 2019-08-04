package com.tw.workshop.awesomebank.model;

import com.tw.workshop.awesomebank.user.model.BankUser;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Bank {
    private final Map<String, BankUser> bankusers = new HashMap<>();
    private String name;

    private String code;

    private String id;

    public Bank(String name, String code) {
        this.name = name;
        this.code = code;
        this.id = UUID.randomUUID().toString();
    }

    public void addUserToBank(BankUser bankUser) {
        this.bankusers.put(bankUser.getBankUserId(), bankUser);
    }

    public BankUser getBankUserByUserId(String userid) {
        return bankusers.get(userid);
    }

}
