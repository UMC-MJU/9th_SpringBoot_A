package com.example.umc9th.domain.review.dto.res;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.umc9th.domain.review.entity.Review;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ReviewResDto {
	private final String memberName;
	private final BigDecimal score;
	private final LocalDateTime createdAt;
	private final String content;
	private final ReplyResDto reply;

	public static ReviewResDto from(Review review) {
		if (review == null) {
			return null;
		}

		return ReviewResDto.builder()
			.memberName(review.getMember().getName())
			.score(review.getScore())
			.createdAt(review.getCreatedAt())
			.content(review.getContent())
			.reply(ReplyResDto.from(review.getReply()))
			.build();
	}
}
