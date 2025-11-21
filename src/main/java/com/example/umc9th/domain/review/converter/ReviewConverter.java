package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.req.ReviewReqDto;
import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.shop.entity.Shop;

public class ReviewConverter {

	public static ReviewResDto.Searching toSearchingDto(Review review) {
		return ReviewResDto.Searching.from(review);
	}

	public static ReviewResDto.Exception toExceptionDTO(String testing) {
		return ReviewResDto.Exception.from(testing);
	}

	public static Review toReview(ReviewReqDto.AddReview reviewReqDto, Member member, Shop shop) {
		return reviewReqDto.toEntity(member, shop);
	}
}
