package com.tw.workshop.awesomebank.account.transaction.report;

import com.tw.workshop.awesomebank.account.model.Account;
import com.tw.workshop.awesomebank.account.model.TransactionType;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class TransactionReportServiceTest {
    @Test
    public void listTransactionsWithNoTransaction() {
        final TransactionReportService transactionReportService = new TransactionReportService();
        final Account account = new Account();
        final List<Account.Transaction> transactions = transactionReportService.getTransactions(account);
        assertTrue(transactions.size() == 0);
    }

    @Test
    public void listTransactions() {
        final TransactionReportService transactionReportService = new TransactionReportService();
        final Account account = new Account();
        account.performCredit(100);
        account.performCredit(100);
        account.performCredit(100);
        account.performDebit(10);
        account.performDebit(10);
        account.performCredit(10);
        final List<Account.Transaction> transactions = transactionReportService.getTransactions(account);
        assertTrue(transactions.stream().filter(transaction -> transaction.getTransactionType() == TransactionType.DEBIT).collect(Collectors.toList()).size() == 2);
        assertTrue(transactions.stream().filter(transaction -> transaction.getTransactionType() == TransactionType.CREDIT).collect(Collectors.toList()).size() == 4);
    }

    @Test
    public void testStringReportForTransactions() {
        final TransactionReportService transactionReportService = new TransactionReportService();
        final Account account = new Account();
        account.performCredit(100);
        account.performCredit(100);
        account.performCredit(100);
        account.performDebit(10);
        account.performDebit(10);
        account.performCredit(10);
        final String transactions = transactionReportService.createTransactionReport(account, new StringOutputTransactionReport());
        System.out.println(transactions);
    }

}