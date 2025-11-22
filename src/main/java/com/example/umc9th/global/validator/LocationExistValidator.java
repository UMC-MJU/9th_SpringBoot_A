package com.example.umc9th.global.validator;

import org.springframework.stereotype.Component;

import com.example.umc9th.global.annotation.ExistLocation;
import com.example.umc9th.global.exception.code.LocationErrorCode;
import com.example.umc9th.global.repository.LocationRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LocationExistValidator implements ConstraintValidator<ExistLocation, Long> {

	private final LocationRepository locationRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = locationRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(LocationErrorCode.BAD_REQUEST.getMessage()).addConstraintViolation();
		}

		return isValid;

	}
}
