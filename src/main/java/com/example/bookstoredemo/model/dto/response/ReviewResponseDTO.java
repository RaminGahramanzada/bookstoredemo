package com.example.bookstoredemo.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    String firstName;
    String lastName;
    String reviewText;
    LocalDateTime reviewDate;
}
