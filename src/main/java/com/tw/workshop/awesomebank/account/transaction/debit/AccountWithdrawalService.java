package com.tw.workshop.awesomebank.account.transaction.debit;

import com.tw.workshop.awesomebank.account.exception.InvalidTransactionException;
import com.tw.workshop.awesomebank.account.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawalService {
    public Account withdrawFromAccount(final Account account, final long withdrawalAmount) {

        if (withdrawalAmount < 0) {
            throw new InvalidTransactionException("You cannot withdraw negative amount");
        }
        if (withdrawalAmount != 0) {
            account.performDebit(withdrawalAmount);
        }
        return account;
    }
}
