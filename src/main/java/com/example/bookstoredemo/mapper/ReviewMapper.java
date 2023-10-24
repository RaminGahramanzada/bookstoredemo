package com.example.bookstoredemo.mapper;


import com.example.bookstoredemo.model.dto.response.ReviewResponseDTO;
import com.example.bookstoredemo.model.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewResponseDTO reviewToReviewResponseDTO(Review review);
}
