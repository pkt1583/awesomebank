package com.tw.workshop.awesomebank.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void createBankUser() {
        UserService userService = new UserService();
        String username = "pkt";
        AwesomeUser bankUser = userService.createUser(username);
        assertEquals(username, bankUser.getUsername());
    }


}