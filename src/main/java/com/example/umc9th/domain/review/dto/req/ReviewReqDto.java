package com.example.umc9th.domain.review.dto.req;

import java.math.BigDecimal;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.shop.annotation.ExistShops;
import com.example.umc9th.domain.shop.entity.Shop;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewReqDto {

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateReview {

		@Min(0)
		@Max(5)
		private BigDecimal score;

		@NotBlank
		private String content;

		@ExistMembers
		private long memberId;

		@ExistShops
		private long shopId;

		public Review toEntity(Member member, Shop shop) {
			return Review.builder()
				.score(score)
				.content(content)
				.member(member)
				.shop(shop)
				.build();
		}
	}
}
