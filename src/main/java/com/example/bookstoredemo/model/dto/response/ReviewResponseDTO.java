package com.example.bookstoredemo.model.dto.response;


import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewResponseDTO {

    Long id;
    String reviewText;
    Integer likeCount;
    LocalDateTime reviewDate;

}
