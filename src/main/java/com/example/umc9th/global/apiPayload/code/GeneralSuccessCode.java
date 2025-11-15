package com.example.umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

	OK(HttpStatus.OK,
		"COMMON200",
		"성공적으로 요청을 처리했습니다."),
	CREATED(HttpStatus.CREATED,
		"COMMON201",
		"성공적으로 리소스를 생성했습니다."),
	NO_CONTENT(HttpStatus.NO_CONTENT,
		"COMMON204",
		"요청이 처리되어 응답할 내용이 없습니다.")
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
