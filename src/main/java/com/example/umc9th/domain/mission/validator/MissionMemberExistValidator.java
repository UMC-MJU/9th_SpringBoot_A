package com.example.umc9th.domain.mission.validator;

import org.springframework.stereotype.Component;

import com.example.umc9th.domain.mission.annotation.ExistMissionMembers;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionMemberRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MissionMemberExistValidator implements ConstraintValidator<ExistMissionMembers, Long> {

	private final MissionMemberRepository missionMemberRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = missionMemberRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(MissionErrorCode.NOT_EXIST_CHALLENGED_MISSION.getMessage()).addConstraintViolation();
		}

		return isValid;

	}
}
