package com.cdx.bas.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BankAccountController {

    @GetMapping("/")
    public String helloBankAccount() {
        return "Hello Bank Account!";
    }
}


