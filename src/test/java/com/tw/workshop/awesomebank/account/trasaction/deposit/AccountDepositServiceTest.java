package com.tw.workshop.awesomebank.account.trasaction.deposit;

import com.tw.workshop.awesomebank.account.exception.InvalidTransactionException;
import com.tw.workshop.awesomebank.account.model.Account;
import com.tw.workshop.awesomebank.account.model.Account.Transaction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountDepositServiceTest {

    private static final long amountForTest = 1000;

    @Test
    public void depositToAccount() {
        final AccountDepositService accountDepositService = new AccountDepositService();
        final Account account = new Account(amountForTest);
        final Account modifiedAccount = accountDepositService.depositToAccount(account, amountForTest);
        assertEquals(amountForTest * 2, modifiedAccount.getCurrentBalance());
    }

    @Test
    public void depositToAccountTransactionCount() {
        final AccountDepositService accountDepositService = new AccountDepositService();
        final Account account = new Account(amountForTest);
        final Account modifiedAccount = accountDepositService.depositToAccount(account, amountForTest);
        final List<Transaction> transactions = modifiedAccount.getTransactions();
        assertTrue(transactions.size() == 1);
        assertTrue(transactions.get(0).getTransactionAmount() == amountForTest);
    }

    @Test
    public void depositToAccountNegative() {
        final AccountDepositService accountDepositService = new AccountDepositService();
        final Account account = new Account();
        try {
            final Account modifiedAccount = accountDepositService.depositToAccount(account, amountForTest * -1);
        } catch (final InvalidTransactionException invalidTransactionException) {
            return;
        }
        fail("Should throw InvalidTransactionException");
    }
}