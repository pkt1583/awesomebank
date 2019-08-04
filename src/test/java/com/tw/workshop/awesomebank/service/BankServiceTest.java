package com.tw.workshop.awesomebank.service;

import com.tw.workshop.awesomebank.user.UserService;
import com.tw.workshop.awesomebank.user.model.BankUser;
import com.tw.workshop.awesomebank.infrastructure.service.IdService;
import com.tw.workshop.awesomebank.user.AwesomeUser;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankServiceTest {

    private static final String BANK_USER = "BANK_USER";

    private static final String DEFUALT_ID_PER_TEST = "1234";
    private UserService userService = new UserService();

    private IdService idService = new IdService() {
        @Override
        public String generateId() {
            return DEFUALT_ID_PER_TEST;
        }
    };

    @Test
    public void findUser() {
        BankService bankService = new BankService(idService);
        BankUser user = getBankUser(bankService);
        BankUser existingUser = bankService.getBankUser(DEFUALT_ID_PER_TEST);
        assertEquals(user, existingUser);
    }

    @Test
    public void createUserInBank() {
        BankService bankService = new BankService(idService);
        BankUser user = getBankUser(bankService);
        assertNotNull(user.getAccount());
        assertTrue(user.getAccount().getCurrentBalance() == 0);
    }

    private BankUser getBankUser(BankService bankService) {

        AwesomeUser awesomeUser = userService.createUser(BANK_USER);
        return bankService.createUserInBank(awesomeUser);
    }

    @Test
    public void checkAccountBalanceForNewUser() {
        BankService bankService = new BankService(idService);
        BankUser user = getBankUser(bankService);
        assertEquals(0, user.getAccount().getCurrentBalance());
        assertNotNull(user.getAccount().getTransactions());
    }
}