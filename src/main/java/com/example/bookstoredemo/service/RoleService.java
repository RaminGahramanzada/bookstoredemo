package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.Enum.ERole;
import com.example.bookstoredemo.model.entity.Role;

public interface RoleService {

    Role findByName(ERole roleName);
}
