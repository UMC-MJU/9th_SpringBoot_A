package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.req.ReviewReqDto;
import com.example.umc9th.domain.review.dto.res.ReplyResDto;
import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.shop.entity.Shop;

public class ReviewConverter {

	public static ReviewResDto.Searching toSearchingDto(Review review) {
		ReplyResDto.Searching replyDto = null;
		if (review.getReply() != null) {
			replyDto = ReplyResDto.Searching.from(review.getReply());
		}

		return ReviewResDto.Searching.of(review, replyDto);
	}

	public static ReviewResDto.Exception toExceptionDTO(String testing) {
		return ReviewResDto.Exception.from(testing);
	}

	public static Review toReview(ReviewReqDto.CreateReview reviewReqDto, Member member, Shop shop) {
		return reviewReqDto.toEntity(member, shop);
	}

	public static ReviewResDto.MyReview toMyReviewDto(Review review) {
		ReplyResDto.MyReview replyDto = null;
		if (review.getReply() != null) {
			replyDto = ReplyResDto.MyReview.from(review.getReply());
		}

		return ReviewResDto.MyReview.of(review, replyDto);
	}
}
