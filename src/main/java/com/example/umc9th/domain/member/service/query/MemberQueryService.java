package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.req.MemberReqDto;
import com.example.umc9th.domain.member.dto.res.MemberResDto;

public interface MemberQueryService {
	MemberResDto.LoginDto login(MemberReqDto.LoginDto dto);
}
