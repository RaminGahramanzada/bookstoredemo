package com.example.bookstoredemo.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "review_text")
    String reviewText;

    @Column(name = "like_count",columnDefinition = "INT default 0")
    Integer likeCount;

    @Column(name = "reviewDate",columnDefinition = "timestamp default now()")
    LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
