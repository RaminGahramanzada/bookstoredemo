package com.example.bookstoredemo.controller;


import com.example.bookstoredemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {


    private final AccountService accountService;

}
