package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.req.MemberReqDto;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.auth.enums.Role;
import com.example.umc9th.global.entity.Location;

public class MemberConverter {
	public static Member toMember(
		MemberReqDto.JoinDto dto,
		String password,
		Role role,
		Location location
	){
		return Member.builder()
			.name(dto.name())
			.nickname(dto.nickname())
			.email(dto.email())
			.password(password)
			.role(role)
			.birth(dto.birth())
			.location(location)
			.phoneNum(dto.phoneNum())
			.detailAddress(dto.detailAddress())
			.gender(dto.gender())
			.build();
	}
}
