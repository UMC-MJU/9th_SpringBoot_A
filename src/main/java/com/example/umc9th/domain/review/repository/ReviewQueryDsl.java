package com.example.umc9th.domain.review.repository;

import java.util.List;

import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;

public interface ReviewQueryDsl {
	List<Review> searchReview(Predicate predicate);
}
