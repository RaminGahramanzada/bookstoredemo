package com.example.bookstoredemo.mapper;


import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.response.AccountResponseDTO;
import com.example.bookstoredemo.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

   // @Mapping(target = "username", source = "signUpRequestDTO.username")
    Account signUpRequestDTOtoAccount(SignUpRequestDTO signUpRequestDTO);

    AccountResponseDTO accountToAccountResponseDTO(Account account);
}
