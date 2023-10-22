package com.example.bookstoredemo.controller;

import com.example.bookstoredemo.model.dto.request.AccountRequestDTO;
import com.example.bookstoredemo.model.entity.Account;
import com.example.bookstoredemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/accounts")
    public class AccountController {

        private final AccountService accountService;

        @PutMapping("/{id}")
        public void update(@PathVariable String id,
                           @RequestBody AccountRequestDTO accountRequestDto) {
            accountService.update(id, accountRequestDto);
        }

        @PatchMapping("add-role/{id}")
        public void addRole(@PathVariable String id, @RequestParam String roleName) {
            accountService.addRole(id, roleName);
        }

        @PatchMapping("delete-role/{id}")
        public void deleteRole(@PathVariable String id, @RequestParam String roleName) {
            accountService.addRole(id, roleName);
        }

        @GetMapping("/get-by-username")
        public Account getByUsername(@RequestParam String username) {
            return accountService.getByUsername(username);
        }

        @GetMapping("/get-by-role-name")
        public List<Account> getByRoleName(@RequestParam String role) {
            return accountService.getByRoleName(role);
        }

        @GetMapping("/all-accounts")
        public List<Account> getAllAccounts() {
            return accountService.getAllAccounts();
        }
    }




