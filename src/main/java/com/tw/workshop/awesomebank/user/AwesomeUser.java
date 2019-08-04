package com.tw.workshop.awesomebank.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AwesomeUser {
    private final String username;
}
