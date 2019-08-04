package com.tw.workshop.awesomebank.account.transaction.report;

import com.tw.workshop.awesomebank.account.model.Account;

import java.util.List;

public interface TransactionReportCreator<T> {
    T createReport(List<Account.Transaction> account);
}
