package com.example.umc9th.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
