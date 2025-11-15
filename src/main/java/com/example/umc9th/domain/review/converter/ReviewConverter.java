package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;

public class ReviewConverter {

	public static ReviewResDto.Searching toSearchingDto(Review review) {
		return ReviewResDto.Searching.from(review);
	}

	public static ReviewResDto.Exception toExceptionDTO(String testing) {
		return ReviewResDto.Exception.from(testing);
	}
}
