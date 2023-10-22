package com.example.bookstoredemo.service.impl;

import com.example.bookstoredemo.model.ERole;
import com.example.bookstoredemo.model.entity.Role;
import com.example.bookstoredemo.repository.RoleRepository;
import com.example.bookstoredemo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByRoleName(ERole eRole) {
        return roleRepository.findByRoleName(eRole);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}