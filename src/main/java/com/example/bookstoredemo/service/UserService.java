package com.example.bookstoredemo.service;

import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.request.UserRequestDTO;
import com.example.bookstoredemo.model.entity.User;

import java.util.List;

public interface UserService {

    void add(SignUpRequestDTO signUpRequestDto);

    User update(Long id, UserRequestDTO userRequestDto);

    void delete(String username);

    User getById(Long id);

    User findUserByUsername(String username);

    List<User> getAllUsers(int page, int size);

    void addReview(Long id, Long reviewId);

}
