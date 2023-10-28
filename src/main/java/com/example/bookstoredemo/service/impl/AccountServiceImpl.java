package com.example.bookstoredemo.service.impl;


import com.example.bookstoredemo.mapper.AccountMapper;
import com.example.bookstoredemo.model.Enum.ERole;
import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.entity.Account;
import com.example.bookstoredemo.model.entity.Role;
import com.example.bookstoredemo.repository.AccountRepository;
import com.example.bookstoredemo.repository.RoleRepository;
import com.example.bookstoredemo.service.AccountService;
import com.example.bookstoredemo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final RoleService roleService;

    private final AccountMapper accountMapper;

    private final RoleRepository roleRepository;


    @Override
    public Account add(SignUpRequestDTO signUpRequestDTO) {
        Role role = roleService.findByName(ERole.ROLE_USER);

        if(!accountRepository.existsByUsername(signUpRequestDTO.getUsername())) {
            Account account = accountMapper.signUpRequestDTOtoAccount(signUpRequestDTO);
            return accountRepository.save(account);
        }
        throw new RuntimeException("Account not saved");
    }

    @Override
    public Account getAccountByUsername(String username){
        return accountRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("account not found"));
    }

    @Override
    public boolean updateUsername(Long id, String username) {
        return false;
    }

    @Override
    public boolean updatePassword(Long id, String password) {
        return false;
    }
}
