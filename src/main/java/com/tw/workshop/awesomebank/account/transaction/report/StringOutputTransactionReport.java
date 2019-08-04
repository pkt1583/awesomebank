package com.tw.workshop.awesomebank.account.transaction.report;

import com.tw.workshop.awesomebank.account.model.Account;

import java.util.List;

public class StringOutputTransactionReport implements TransactionReportCreator<String> {

    @Override
    public String createReport(final List<Account.Transaction> account) {
        final StringBuilder sb = new StringBuilder();
        account.forEach(transaction -> sb.append(" | ")
                .append(transaction.getTransactionId())
                .append(" | ")
                .append(transaction.getTransactionType().name())
                .append(" | ")
                .append(transaction.getTransactionAmount())
                .append(" | ").append(System.lineSeparator()));
    }
}
