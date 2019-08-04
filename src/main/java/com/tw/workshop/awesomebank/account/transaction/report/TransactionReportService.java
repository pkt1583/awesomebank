package com.tw.workshop.awesomebank.account.transaction.report;

import com.tw.workshop.awesomebank.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionReportService {
    public List<Account.Transaction> getTransactions(final Account account) {
        return account.getTransactions();
    }
}
