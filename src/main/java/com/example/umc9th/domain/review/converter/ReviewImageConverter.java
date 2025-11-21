package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.entity.ReviewImage;
import com.example.umc9th.global.entity.Uuid;

public class ReviewImageConverter {

	public static ReviewImage toReviewImage(String url, Review review, Uuid uuid) {
		return ReviewImage.builder()
			.url(url)
			.review(review)
			.uuid(uuid)
			.build();
	}
}
