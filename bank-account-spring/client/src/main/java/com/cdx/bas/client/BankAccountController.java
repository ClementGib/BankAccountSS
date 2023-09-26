package com.cdx.bas.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    @GetMapping("/")
    public String helloBankAccount() {
        return "Hello Bank Account!";
    }
}


