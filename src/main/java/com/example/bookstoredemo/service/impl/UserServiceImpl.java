package com.example.bookstoredemo.service.impl;

import com.example.bookstoredemo.exception.UserNotFoundException;
import com.example.bookstoredemo.mapper.UserMapper;
import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.request.UserRequestDTO;
import com.example.bookstoredemo.model.dto.response.UserResponseDTO;
import com.example.bookstoredemo.model.entity.Account;
import com.example.bookstoredemo.model.entity.User;
import com.example.bookstoredemo.repository.UserRepository;
import com.example.bookstoredemo.service.AccountService;
import com.example.bookstoredemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AccountService accountService;

    private final UserMapper userMapper;

    public List<UserResponseDTO> getAllUsers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return userRepository.findAll(paging).getContent().stream()
                .map(userMapper::userToUserResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->new UserNotFoundException("user not found"));
        UserResponseDTO userResponseDTO = userMapper.userToUserResponseDTO(user);
        return userResponseDTO;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public boolean updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setContactNumber(userRequestDTO.getContactNumber());

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("message"));
        userRepository.delete(user);
        return true;
    }

    @Override
    public boolean addRoleToUser(Long id, String roleName) {
        return false;
    }

    @Override
    public boolean deleteRoleFromUser(Long id, String roleName) {
        return false;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean addUser(SignUpRequestDTO signUpRequestDTO) {
        Account account = accountService.add(signUpRequestDTO);

        User user = userMapper.signUpRequestDTOtoUser(signUpRequestDTO);
        user.setAccount(account);
        userRepository.save(user);

        return true;
    }
}
