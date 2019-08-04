package com.tw.workshop.awesomebank.account.transaction.debit;

import com.tw.workshop.awesomebank.account.exception.InsufficientFundsException;
import com.tw.workshop.awesomebank.account.exception.InvalidTransactionException;
import com.tw.workshop.awesomebank.account.model.Account;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountWithdrawalServiceTest {
    private static final long amountForTest = 1000;

    @Test
    public void performWithdraw() {
        final AccountWithdrawalService accountWithdrawalService = new AccountWithdrawalService();
        final Account account = new Account(amountForTest);
        final Account modifiedAccount = accountWithdrawalService.withdrawFromAccount(account, amountForTest);
        assertEquals(0, modifiedAccount.getCurrentBalance());
    }

    @Test
    public void performWithdrawWithNegativeAmount() {
        final AccountWithdrawalService accountWithdrawalService = new AccountWithdrawalService();
        final Account account = new Account(amountForTest);
        try {
            final Account modifiedAccount = accountWithdrawalService.withdrawFromAccount(account, amountForTest * -1);
        } catch (final InvalidTransactionException e) {
            return;
        }
        fail("Should throw exception for invalid transaction with negative amount");

    }

    @Test
    public void performWithdrawalOverLimit() {
        final AccountWithdrawalService accountWithdrawalService = new AccountWithdrawalService();
        final Account account = new Account();
        try {
            final Account modifiedAccount = accountWithdrawalService.withdrawFromAccount(account, amountForTest);
        } catch (final InsufficientFundsException isfe) {
            return;
        }
        fail("Should throw Insufficient funds exception");
    }

    @Test
    public void withdrawalTransactionsCheck() {
        final AccountWithdrawalService accountWithdrawalService = new AccountWithdrawalService();
        final Account account = new Account(amountForTest);
        final Account modifiedAccount = accountWithdrawalService.withdrawFromAccount(account, amountForTest);
        final List<Account.Transaction> transactions = modifiedAccount.getTransactions();
        assertTrue(transactions.size() == 1);
        assertTrue(transactions.get(0).getTransactionAmount() == amountForTest);
    }
}