package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.member.dto.req.MemberReqDto;

public interface MemberCommandService {
	void signup(MemberReqDto.JoinDto dto);
}
