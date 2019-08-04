package com.tw.workshop.awesomebank.account.trasaction.deposit;

import com.tw.workshop.awesomebank.account.exception.InvalidTransactionException;
import com.tw.workshop.awesomebank.account.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositService {
    public Account depositToAccount(final Account account, final long depositedAmount) {
        if (depositedAmount < 0) {
            throw new InvalidTransactionException("Cannot deposit negative amount " + depositedAmount + " to account with id " + account.getAccountId());
        }
        account.performCredit(depositedAmount);
        return account;
    }
}
