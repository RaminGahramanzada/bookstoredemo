package com.example.bookstoredemo.model.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequestDTO {


    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    String contactNumber;
}

