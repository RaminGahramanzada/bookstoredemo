package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.entity.Account;

public interface AccountService {

    Account add(SignUpRequestDTO signUpRequestDTO);

    Account getAccountByUsername(String username);

    boolean updateUsername(Long id, String username);

    boolean updatePassword(Long id, String password);
}
