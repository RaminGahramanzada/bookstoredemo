package com.example.bookstoredemo.service;

import com.example.bookstoredemo.model.dto.request.AccountRequestDTO;
import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.entity.Account;

import java.util.List;

public interface AccountService {

    Account add(SignUpRequestDTO signUpRequestDto);

    void addRole(String id, String roleName);

    void deleteRole(String id, String roleName);

    Account update(String id, AccountRequestDTO accountRequestDto);

    void delete(Account account);

    Account getByUsername(String username);

    List<Account> getByRoleName(String role);

    List<Account> getAllAccounts();
}
