package com.example.bookstoredemo.repository;

;
import com.example.bookstoredemo.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByUsername(String username);

    boolean existsByUsername(String username);
}
