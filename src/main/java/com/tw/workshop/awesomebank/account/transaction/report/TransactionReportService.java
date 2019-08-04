package com.tw.workshop.awesomebank.account.transaction.report;

import com.tw.workshop.awesomebank.account.model.Account;

import java.util.List;

public abstract class TransactionReportService<T, U extends TransactionReportCreator> {
    public List<Account.Transaction> getTransactions(final Account account) {
        return account.getTransactions();
    }

    public T createTransactionReport(final Account account, final U reportCreator) {
        return reportCreator.createReport(getTransactions(account));
    }
}
