package com.datdt.AssignmentSpringboot.service;

import java.util.Optional;

import com.datdt.AssignmentSpringboot.entity.Account;
import com.datdt.AssignmentSpringboot.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> getAccountByUsername(String username){
        return accountRepository.getByUsername(username);
    }

    public Account findByUsername(String username) throws Exception{
        Account currentAccount =  accountRepository.findAccountByUsername(username);
        if(currentAccount == null){
            throw new Exception("User Not Found!!");
        } else {
            return currentAccount;
        }
    }

    

    
}
