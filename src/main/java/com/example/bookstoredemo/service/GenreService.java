package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.dto.request.GenreRequestDTO;
import com.example.bookstoredemo.model.entity.Genre;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres(Pageable pageable);

    Genre getGenreById(Long id);

    Genre getGenreByName(String genreName);

    boolean addGenre(GenreRequestDTO genreRequestDTO);

    boolean deleteGenre(Long id);
}
