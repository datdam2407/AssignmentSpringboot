package com.datdt.AssignmentSpringboot.test.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Account;
import com.datdt.AssignmentSpringboot.repository.AccountRepository;
import com.datdt.AssignmentSpringboot.service.AccountService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AccountTest {

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;
   
    List<Account> list;
    
    @BeforeEach
    public void setUp(){
        list = new ArrayList<>();
        Account account1 = new Account("datddtt", "datdan", "123456", "dat1dam@gmail.com", "acpected", "q1", "0123456789", new Date());
        Account account2 = new Account("datddtt11", "datdan", "123456", "dat1dam111@gmail.com", "acpected", "q1", "0123456789", new Date());
        list.add(account1);
        list.add(account2);
    }
    
    @Test
    public void test_get_all_success() throws Exception {
    when(accountRepository.findAll()).thenReturn(list);
    assertEquals(accountService.getAccountByUsername(list.get(0).getUsername()), list);
    verify(accountRepository, times(1)).findAll();
    verify(accountService, times(1)).getAccountByUsername(list.get(0).getUsername());
}
}
