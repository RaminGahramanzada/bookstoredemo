package com.example.bookstoredemo.controller;

import com.example.bookstoredemo.model.dto.request.SignUpRequestDTO;
import com.example.bookstoredemo.model.dto.request.UserRequestDTO;
import com.example.bookstoredemo.model.dto.response.UserResponseDTO;
import com.example.bookstoredemo.model.entity.User;
import com.example.bookstoredemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    public boolean addUser(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) {
        return userService.addUser(signUpRequestDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDTO> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "2") int size) {
        return userService.getAllUsers(page, size);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username")
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/{id}")
    public boolean updateUser(@PathVariable Long id,
                              @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PatchMapping("/{id}/add-role")
    public boolean addRoleToUser(@PathVariable Long id,
                                 @RequestParam String roleName) {
        return userService.addRoleToUser(id, roleName);
    }

    @PatchMapping("/{id}/delete-role")
    public boolean deleteRoleFromUser(@PathVariable Long id,
                                      @RequestParam String roleName) {
        return userService.deleteRoleFromUser(id, roleName);
    }
}
