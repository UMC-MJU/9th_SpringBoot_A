package com.example.umc9th.domain.review.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

	OK(HttpStatus.OK,
		"REVIEW200",
		"성공적으로 리뷰 관련 요청을 처리했습니다."),
	CREATED(HttpStatus.CREATED,
		"REVIEW201",
		"리뷰 정보를 성공적으로 추가했습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
