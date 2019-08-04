package com.tw.workshop.awesomebank.user;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public AwesomeUser createUser(String userName) {
        return AwesomeUser.builder().username(userName).build();
    }
}
