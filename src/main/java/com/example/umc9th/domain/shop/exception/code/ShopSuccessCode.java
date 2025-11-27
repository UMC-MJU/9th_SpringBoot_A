package com.example.umc9th.domain.shop.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShopSuccessCode implements BaseSuccessCode {

	CREATED(HttpStatus.CREATED,
		"SHOP201",
		"가게 정보를 성공적으로 추가했습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
