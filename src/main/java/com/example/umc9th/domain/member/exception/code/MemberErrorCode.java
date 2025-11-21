package com.example.umc9th.domain.member.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "MEMBER400_1", "해당하는 사용자를 찾을 수 없습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
