package com.example.umc9th.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.review.entity.ReviewImage;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long> {
}
