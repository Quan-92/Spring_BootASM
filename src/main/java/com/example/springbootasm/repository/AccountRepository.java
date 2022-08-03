package com.example.springbootasm.repository;

import com.example.assignmentspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByUsername(String username);

}