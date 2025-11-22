package com.example.umc9th.domain.mission.validator;

import org.springframework.stereotype.Component;

import com.example.umc9th.domain.mission.annotation.ExistMissions;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMissions, Long> {

	private final MissionRepository missionRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = missionRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(MissionErrorCode.BAD_REQUEST.getMessage()).addConstraintViolation();
		}

		return isValid;

	}
}
