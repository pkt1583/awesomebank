package com.tw.workshop.awesomebank.service;

import com.tw.workshop.awesomebank.infrastructure.service.IdService;
import com.tw.workshop.awesomebank.model.Bank;
import com.tw.workshop.awesomebank.user.AwesomeUser;
import com.tw.workshop.awesomebank.user.model.BankUser;
import org.springframework.stereotype.Component;

@Component
public class BankService {

    private final Bank bank;

    private final IdService idService;

    public BankService(final IdService idService) {
        this.bank = new Bank("AwesomeBank", "ABB");
        this.idService = idService;
    }

    public BankUser createUserInBank(final AwesomeUser user) {
        final BankUser bankUser = new BankUser(user, idService.generateId());
        bank.addUserToBank(bankUser);
        return bankUser;
    }

    public BankUser getBankUser(final String userid) {
        return bank.getBankUserByUserId(userid);
    }
}
