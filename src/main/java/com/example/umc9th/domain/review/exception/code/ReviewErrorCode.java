package com.example.umc9th.domain.review.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
	TEST_EXCEPTION(HttpStatus.BAD_REQUEST, "REVIEW400_1", "테스트"),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
