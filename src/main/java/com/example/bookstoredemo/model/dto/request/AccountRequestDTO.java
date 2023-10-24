package com.example.bookstoredemo.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountRequestDTO {

    String username;
    String password;

}
