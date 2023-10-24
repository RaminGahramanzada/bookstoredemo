package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.request.UserRequestDTO;
import com.example.bookstoredemo.model.dto.response.UserResponseDTO;
import com.example.bookstoredemo.model.entity.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    boolean addUser(@Valid SignUpRequestDTO signUpRequestDTO);

    List<UserResponseDTO> getAllUsers(int page, int size);

    UserResponseDTO getUserById(Long id);

    User getUserByUsername(String username);

    boolean updateUser(Long id, @Valid UserRequestDTO userRequestDTO);

    boolean deleteUser(Long id);

    boolean addRoleToUser(Long id, String roleName);

    boolean deleteRoleFromUser(Long id, String roleName);
}
