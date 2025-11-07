package com.example.umc9th.domain.review.dto.res;

import java.time.LocalDateTime;

import com.example.umc9th.domain.review.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ReplyResDto {
	private final LocalDateTime createdAt;
	private final String content;

	public static ReplyResDto from(Reply reply) {
		if (reply == null) {
			return null;
		}

		return ReplyResDto.builder()
			.createdAt(reply.getCreatedAt())
			.content(reply.getContent())
			.build();
	}
}
