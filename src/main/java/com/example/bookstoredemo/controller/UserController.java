package com.example.bookstoredemo.controller;


import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.request.UserRequestDTO;
import com.example.bookstoredemo.model.entity.User;
import com.example.bookstoredemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void add(@RequestBody @Valid SignUpRequestDTO signUpRequestDto) {
        userService.add(signUpRequestDto);
    }

    @PatchMapping("/{id}/{reviewId}")
    public void addReview(@PathVariable Long id, @PathVariable Long reviewId) {
        userService.addReview(id, reviewId);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody UserRequestDTO userRequestDto) {
        userService.update(id, userRequestDto);
    }

    @DeleteMapping
    public void delete(@RequestParam String username) {
        userService.delete(username);
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "2") int size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/get-by-id/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/get-by-username")
    public User getByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }


}
