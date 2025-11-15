package com.example.umc9th.domain.review.dto.res;

import java.time.LocalDateTime;

import com.example.umc9th.domain.review.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class ReplyResDto {

	@Getter
	@Builder
	@RequiredArgsConstructor
	public static class Searching {
		private final LocalDateTime createdAt;
		private final String content;

		public static ReplyResDto.Searching from(Reply reply) {
			if (reply == null) {
				return null;
			}

			return ReplyResDto.Searching.builder()
				.createdAt(reply.getCreatedAt())
				.content(reply.getContent())
				.build();
		}
	}
}
