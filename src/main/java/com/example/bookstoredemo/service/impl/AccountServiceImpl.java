package com.example.bookstoredemo.service.impl;

import com.example.bookstoredemo.mapper.AccountMapper;
import com.example.bookstoredemo.model.ERole;
import com.example.bookstoredemo.model.dto.request.AccountRequestDTO;
import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.entity.Account;
import com.example.bookstoredemo.model.entity.Role;
import com.example.bookstoredemo.repository.AccountRepository;
import com.example.bookstoredemo.service.AccountService;
import com.example.bookstoredemo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleService roleService;
    private final AccountMapper accountMapper;


    @Override
    public Account add(SignUpRequestDTO signUpRequestDto) {
        return null;
    }

    @Override
    public void addRole(String id, String roleName) {
        ERole eRole = ERole.USER;
        if (roleName.equalsIgnoreCase("ADMIN"))
            eRole = ERole.ADMIN;
        Role role = roleService.findByRoleName(eRole);
        if (!accountRepository.existsByRoles(role)){
            Account account = accountRepository.findById(id).get();
            account.getRoles().add(role);
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteRole(String id, String roleName) {
        ERole eRole = ERole.ADMIN;
        if (roleName.equalsIgnoreCase("USER"))
            eRole = ERole.USER;
        Role role = roleService.findByRoleName(eRole);
        if (accountRepository.existsByRoles(role)){
            Account account = accountRepository.findById(id).get();
            account.getRoles().remove(role);
            accountRepository.save(account);
        }
    }

    //@Override
    public Account update(String id, AccountRequestDTO accountRequestDto) {
        Account account = accountRepository.findById(id).get();
        if (accountRequestDto.getUsername() != null && accountRequestDto.getUsername() != account.getUsername())
            account.setUsername(accountRequestDto.getUsername());
        if (accountRequestDto.getPassword() != null)
            account.setPassword(accountRequestDto.getPassword());
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getByRoleName(String role) {
        if (role.equalsIgnoreCase("USER"))
            return accountRepository.findAccountsByRoles(new Role(1L, ERole.USER));
        else if (role.equalsIgnoreCase("ADMIN"))
            return accountRepository.findAccountsByRoles(new Role(2L, ERole.ADMIN));
        else return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


}