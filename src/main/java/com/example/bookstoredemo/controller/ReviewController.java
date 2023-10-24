package com.example.bookstoredemo.controller;


import com.example.bookstoredemo.model.dto.response.ReviewResponseDTO;
import com.example.bookstoredemo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping
    public List<ReviewResponseDTO> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("{id}")
    public ReviewResponseDTO getReviewById(@PathVariable Long id){
        return reviewService.getReviewById(id);
    }
}

