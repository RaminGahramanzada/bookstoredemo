package com.example.bookstoredemo.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {

    String firstName;
    String lastName;
    String email;
    String contactNumber;
    String username;
}
