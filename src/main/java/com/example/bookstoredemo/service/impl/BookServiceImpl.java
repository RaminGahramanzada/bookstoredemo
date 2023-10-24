package com.example.bookstoredemo.service.impl;


import com.example.bookstoredemo.model.dto.request.BookRequestDTO;
import com.example.bookstoredemo.model.entity.Book;
import com.example.bookstoredemo.repository.BookRepository;
import com.example.bookstoredemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(Pageable pageable) {
        return null;
    }

    @Override
    public List<Book> getAllBooksByGenre(String genreName, Pageable pageable) {
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public boolean addBook(BookRequestDTO bookRequestDTO) {
        return false;
    }

    @Override
    public boolean deleteBook(Long id) {
        return false;
    }
}
