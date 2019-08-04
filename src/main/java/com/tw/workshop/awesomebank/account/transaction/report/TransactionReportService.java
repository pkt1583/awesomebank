package com.tw.workshop.awesomebank.account.transaction.report;

import com.tw.workshop.awesomebank.account.model.Account;

import java.util.List;

public class TransactionReportService {
    public List<Account.Transaction> getTransactions(final Account account) {
        return account.getTransactions();
    }

    public <T> T createTransactionReport(final Account account, final TransactionReportCreator<T> reportCreator) {
        return reportCreator.createReport(getTransactions(account));
    }
}
