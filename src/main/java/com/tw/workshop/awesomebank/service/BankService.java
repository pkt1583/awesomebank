package com.tw.workshop.awesomebank.service;

import com.tw.workshop.awesomebank.model.Bank;
import com.tw.workshop.awesomebank.user.model.BankUser;
import com.tw.workshop.awesomebank.infrastructure.service.IdService;
import com.tw.workshop.awesomebank.user.AwesomeUser;
import org.springframework.stereotype.Component;

@Component
public class BankService {

    private final Bank bank;

    private final IdService idService;

    public BankService(IdService idService) {
        this.bank = new Bank("AwesomeBank", "ABB");
        this.idService = idService;
    }

    public BankUser createUserInBank(AwesomeUser user) {
        BankUser bankUser = new BankUser(user, idService.generateId());
        bank.addUserToBank(bankUser);
        return bankUser;
    }

    public BankUser getBankUser(String userid) {
        return bank.getBankUserByUserId(userid);
    }
}
