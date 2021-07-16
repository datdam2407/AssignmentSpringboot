package com.datdt.AssignmentSpringboot.repository;

import java.util.Optional;
import com.datdt.AssignmentSpringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
    public interface AccountRepository extends JpaRepository<Account, Long>{   
        Optional<Account> getByUsername(String username);
        Boolean existsByUsername(String username);
        Boolean existsByEmail(String email);
        
        @Query("FROM Account WHERE username = ?1")
        Account findAccountByUsername(String username);
} 

