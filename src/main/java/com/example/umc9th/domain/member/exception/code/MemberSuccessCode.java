package com.example.umc9th.domain.member.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

	CREATED(HttpStatus.CREATED,
		"MEMBER201",
		"회원 정보를 성공적으로 추가했습니다."),
	LOGIN_SUCCESS(HttpStatus.OK,
		"MEMBER200_1",
		"로그인에 성공했습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
