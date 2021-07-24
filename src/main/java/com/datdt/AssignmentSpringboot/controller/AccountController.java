package com.datdt.AssignmentSpringboot.controller;


import java.util.Optional;

import com.datdt.AssignmentSpringboot.entity.Account;
import com.datdt.AssignmentSpringboot.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/{username}")
    public Optional<Account> getAccountByUsername(@PathVariable(name = "username") String username){
        return this.accountService.getAccountByUsername(username);
    }
    
}

