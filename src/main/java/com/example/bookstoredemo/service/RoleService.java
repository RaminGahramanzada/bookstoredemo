package com.example.bookstoredemo.service;

import com.example.bookstoredemo.model.ERole;
import com.example.bookstoredemo.model.entity.Role;

import java.util.List;

public interface RoleService {
    Role findByRoleName(ERole eRole);

    List<Role> getAllRoles();
}
