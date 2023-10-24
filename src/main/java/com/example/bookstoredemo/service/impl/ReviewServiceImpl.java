package com.example.bookstoredemo.service.impl;

import com.example.bookstoredemo.mapper.ReviewMapper;
import com.example.bookstoredemo.model.dto.request.ReviewRequestDTO;
import com.example.bookstoredemo.model.dto.response.ReviewResponseDTO;
import com.example.bookstoredemo.model.entity.Review;
import com.example.bookstoredemo.repository.ReviewRepository;
import com.example.bookstoredemo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    @Override
    public List<Review> getAllReviewsByBookId(Long bookId, Sort sort) {
        return null;
    }

    @Override
    public List<Review> getAllReviewsByUserId(Long userId, Sort sort) {
        return null;
    }

    @Override
    public boolean addReview(Long userId, Long bookId, ReviewRequestDTO reviewRequestDTO) {
        return false;
    }

    @Override
    public boolean deleteReview(Long userId, Long bookId, Long reviewId) {
        return false;
    }

    @Override
//    @Transactional
    public List<ReviewResponseDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.getAllReviews();

        reviews.forEach(review -> System.out.println(review.getBook().getTitle()));
        return reviews.stream()
                .map(reviewMapper::reviewToReviewResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDTO getReviewById(Long id) {
        return reviewMapper.reviewToReviewResponseDTO(reviewRepository
                .findById(id).orElseThrow());
    }
}
