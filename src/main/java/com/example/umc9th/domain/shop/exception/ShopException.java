package com.example.umc9th.domain.shop.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class ShopException extends GeneralException {
	public ShopException(BaseErrorCode code) {
		super(code);
	}
}
