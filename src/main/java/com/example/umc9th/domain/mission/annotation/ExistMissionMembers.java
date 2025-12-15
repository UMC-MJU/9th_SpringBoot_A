package com.example.umc9th.domain.mission.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.umc9th.domain.mission.validator.MissionMemberExistValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = MissionMemberExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMissionMembers {

	String message() default "등록한 해당 미션이 존재하지 않습니다.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
