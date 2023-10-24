package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.dto.request.AuthorRequestDTO;
import com.example.bookstoredemo.model.entity.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {


    List<Author> getAllAuthors(Pageable pageable);

    Author getAuthorById(Long id);

    Author getAuthorByFullName(String fullName);

    boolean addAuthor(AuthorRequestDTO authorRequestDTO);

    boolean deleteAuthor(Long id);
}
