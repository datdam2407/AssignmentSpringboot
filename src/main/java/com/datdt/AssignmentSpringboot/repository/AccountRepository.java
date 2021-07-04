package com.datdt.AssignmentSpringboot.repository;

import java.util.Optional;
import com.datdt.AssignmentSpringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface AccountRepository extends JpaRepository<Account, Long>{   
        Optional<Account> findByUsername(String username);
        Boolean existsByUsername(String username);
        Boolean existsByEmail(String email);
} 

