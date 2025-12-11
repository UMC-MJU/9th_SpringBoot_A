package com.example.umc9th.global.validator;

import org.springframework.stereotype.Component;

import com.example.umc9th.global.annotation.OverZeroInteger;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OverZeroIntegerValidator implements ConstraintValidator<OverZeroInteger, Integer> {

	@Override
	public boolean isValid(Integer integer, ConstraintValidatorContext context) {
		boolean isValid = (integer == null || integer < 1);

		if (isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("0보다 큰 값을 입력해주세요.").addConstraintViolation();
		}

		return !isValid;
	}
}
