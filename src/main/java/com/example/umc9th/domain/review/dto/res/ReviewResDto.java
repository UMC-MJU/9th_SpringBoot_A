package com.example.umc9th.domain.review.dto.res;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.umc9th.domain.review.entity.Review;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class ReviewResDto {
	@Getter
	@Builder
	@RequiredArgsConstructor
	public static class Searching {
		private final String memberName;
		private final BigDecimal score;
		private final LocalDateTime createdAt;
		private final String content;
		private final ReplyResDto.Searching reply;

		public static ReviewResDto.Searching from(Review review) {
			if (review == null) {
				return null;
			}

			return ReviewResDto.Searching.builder()
				.memberName(review.getMember().getName())
				.score(review.getScore())
				.createdAt(review.getCreatedAt())
				.content(review.getContent())
				.reply(ReplyResDto.Searching.from(review.getReply()))
				.build();
		}
	}
}
