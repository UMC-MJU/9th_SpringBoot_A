package com.example.umc9th.global.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.umc9th.global.validator.OverZeroIntegerValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = OverZeroIntegerValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface OverZeroInteger {

	String message() default "0보다 큰 값을 입력해주세요.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
