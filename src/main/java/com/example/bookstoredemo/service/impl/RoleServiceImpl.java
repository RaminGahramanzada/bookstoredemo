package com.example.bookstoredemo.service.impl;


import com.example.bookstoredemo.model.Enum.ERole;
import com.example.bookstoredemo.model.entity.Role;
import com.example.bookstoredemo.repository.RoleRepository;
import com.example.bookstoredemo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public Role findByName(ERole roleName) {
        return roleRepository.findByRoleName(roleName).orElseThrow();
    }
}
