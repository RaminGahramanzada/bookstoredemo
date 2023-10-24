package com.example.bookstoredemo.service.impl;


import com.example.bookstoredemo.model.dto.request.AuthorRequestDTO;
import com.example.bookstoredemo.model.entity.Author;
import com.example.bookstoredemo.repository.AuthorRepository;
import com.example.bookstoredemo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors(Pageable pageable) {
        return null;
    }

    @Override
    public Author getAuthorById(Long id) {
        return null;
    }

    @Override
    public Author getAuthorByFullName(String fullName) {
        return null;
    }

    @Override
    public boolean addAuthor(AuthorRequestDTO authorRequestDTO) {
        return false;
    }

    @Override
    public boolean deleteAuthor(Long id) {
        return false;
    }
}
