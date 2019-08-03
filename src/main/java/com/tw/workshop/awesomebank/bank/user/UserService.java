package com.tw.workshop.awesomebank.bank.user;

import com.tw.workshop.awesomebank.bank.user.model.BankUser;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public BankUser createBankUser(String username) {
        return new BankUser(username);
    }
}
