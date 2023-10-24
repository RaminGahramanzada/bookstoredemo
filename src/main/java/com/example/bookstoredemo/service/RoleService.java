package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.ERole;
import com.example.bookstoredemo.model.entity.Role;

import java.util.Optional;

public interface RoleService {

    Role findByName(ERole roleName);
}
