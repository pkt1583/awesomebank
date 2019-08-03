package com.tw.workshop.awesomebank.bank.account.exception;

public class InvalidTransaction extends RuntimeException {
    public InvalidTransaction(String message) {
        super(message);
    }
}
