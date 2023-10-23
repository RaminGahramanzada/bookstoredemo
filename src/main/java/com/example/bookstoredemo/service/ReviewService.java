package com.example.bookstoredemo.service;

import com.example.bookstoredemo.model.dto.request.ReviewRequestDTO;
import com.example.bookstoredemo.model.dto.response.ReviewResponseDTO;
import com.example.bookstoredemo.model.entity.Review;

import java.util.List;
import java.util.Set;

public interface ReviewService {

    void add(ReviewRequestDTO reviewRequestDto);

    Review update(Long id, ReviewRequestDTO reviewRequestDto);

    void delete(Long id);

    void deleteAll(Set<Review> reviews);

    List<Review> getByUsername(String username);

    List<ReviewResponseDTO> getByBookTitle(String title);

    Review getById(Long id);

    List<Review> getAllReviews();

    void calculateLikes(Long id, boolean like);

}
