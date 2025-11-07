package com.example.umc9th.domain.review.service;

import java.util.List;

import com.example.umc9th.domain.review.dto.res.ReviewResDto;

public interface ReviewService {
	List<ReviewResDto> searchReview(long memberId, String type, String query);
}
