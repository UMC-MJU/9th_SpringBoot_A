package com.example.umc9th.domain.member.dto.res;

import lombok.Builder;

public class MemberResDto {

	@Builder
	public record LoginDto(
		Long memberId,
		String accessToken
	){}
}
