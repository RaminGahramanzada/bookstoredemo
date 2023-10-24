package com.example.bookstoredemo.service;


import com.example.bookstoredemo.model.dto.request.ReviewRequestDTO;
import com.example.bookstoredemo.model.dto.response.ReviewResponseDTO;
import com.example.bookstoredemo.model.entity.Review;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviewsByBookId(Long bookId, Sort sort);

    List<Review> getAllReviewsByUserId(Long userId, Sort sort);

    boolean addReview(Long userId, Long bookId, ReviewRequestDTO reviewRequestDTO);

    boolean deleteReview(Long userId, Long bookId, Long reviewId);

    List<ReviewResponseDTO> getAllReviews();

    ReviewResponseDTO getReviewById(Long id);
}
