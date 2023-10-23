package com.example.bookstoredemo.service.impl;


import com.example.bookstoredemo.mapper.UserMapper;
import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.request.UserRequestDTO;
import com.example.bookstoredemo.model.entity.Account;
import com.example.bookstoredemo.model.entity.Review;
import com.example.bookstoredemo.model.entity.User;
import com.example.bookstoredemo.repository.UserRepository;
import com.example.bookstoredemo.service.AccountService;
import com.example.bookstoredemo.service.ReviewService;
import com.example.bookstoredemo.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final ReviewService reviewService;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, AccountService accountService, @Lazy ReviewService reviewService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.reviewService = reviewService;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<User> users = userRepository.findAll(paging).getContent();
        return users;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(SignUpRequestDTO signUpRequestDto) {
        Account account = accountService.add(signUpRequestDto);

        User user = userMapper.signUpRequestDtoToUser(signUpRequestDto);
        userRepository.save(user);
    }

    @Override
    public User update(Long id, UserRequestDTO userRequestDto) {
        User user = userRepository.findById(id).get();
        if (userRequestDto.getFirstName() != null)
            user.setFirstName(userRequestDto.getFirstName());
        if (userRequestDto.getLastName() != null)
            user.setLastName(userRequestDto.getLastName());
        if (userRequestDto.getEmail() != null)
            user.setEmail(userRequestDto.getEmail());
        if (userRequestDto.getContactNumber() != null)
            user.setContactNumber(userRequestDto.getContactNumber());
        return userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        User user = findUserByUsername(username);
        Account account = user.getAccount();
        Set<Review> reviews = user.getReviews();
        reviews.forEach(r -> r.setUser(null));
        user.setAccount(null);
        userRepository.delete(user);
        accountService.delete(account);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByAccount_Username(username);
    }

    @Override
    public void addReview(Long id, Long reviewId) {
        Review review = reviewService.getById(reviewId);
        if (!userRepository.existsByReviews(review)){
            User user = getById(id);
            user.getReviews().add(review);
            userRepository.save(user);
        }
    }
}

