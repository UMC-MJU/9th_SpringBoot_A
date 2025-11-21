package com.example.umc9th.domain.member.validator;

import org.springframework.stereotype.Component;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMembers, Long> {

	private final MemberRepository memberRepository;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = memberRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(MemberErrorCode.BAD_REQUEST.getMessage()).addConstraintViolation();
		}

		return isValid;

	}
}
