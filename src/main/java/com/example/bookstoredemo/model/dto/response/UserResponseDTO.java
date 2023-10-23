package com.example.bookstoredemo.model.dto.response;

import com.example.bookstoredemo.model.entity.Account;
import com.example.bookstoredemo.model.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    String firstName;
    String lastName;
    String email;
    String contactNumber;
    Account account;
    Set<Review> reviews;
}
