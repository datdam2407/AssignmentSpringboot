package com.datdt.AssignmentSpringboot.sercurity.service;

import com.datdt.AssignmentSpringboot.entity.Account;
import com.datdt.AssignmentSpringboot.repository.AccountRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class accountDeatailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public accountDeatailService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username)
                            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
        return accountDetailImpl.build(account);
    }
    
}
