package com.example.umc9th.domain.shop.validator;

import org.springframework.stereotype.Component;

import com.example.umc9th.domain.shop.annotation.ExistShops;
import com.example.umc9th.domain.shop.exception.code.ShopErrorCode;
import com.example.umc9th.domain.shop.repository.ShopRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ShopExistValidator implements ConstraintValidator<ExistShops, Long> {

	private final ShopRepository shopRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = shopRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ShopErrorCode.BAD_REQUEST.getMessage()).addConstraintViolation();
		}

		return isValid;

	}
}
