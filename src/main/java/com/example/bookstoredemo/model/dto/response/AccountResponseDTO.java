package com.example.bookstoredemo.model.dto.response;

import com.example.bookstoredemo.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {

    String username;
    String password;
    boolean isActive;
    Set<Role> roles;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
