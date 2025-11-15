package com.example.umc9th.domain.review.repository;

import java.util.List;

import com.example.umc9th.domain.review.entity.Review;

public interface ReviewQueryDsl {
	List<Review> searchReview(long memberId, String type, String query);
}
