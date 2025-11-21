package com.example.umc9th.domain.shop.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShopErrorCode implements BaseErrorCode {
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "SHOP400_1", "해당하는 가게를 찾을 수 없습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
