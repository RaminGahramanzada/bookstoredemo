package com.example.bookstoredemo.mapper;

import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.response.UserResponseDTO;
import com.example.bookstoredemo.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User signUpRequestDtoToUser(SignUpRequestDTO signUpRequestDto);

    UserResponseDTO userToUserResponseDto(User user);
}
