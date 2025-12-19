package com.example.umc9th.domain.member.dto.req;

import java.time.LocalDate;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.global.enums.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MemberReqDto {

	public record JoinDto (
		@NotBlank
		String name,

		@NotBlank
		String nickname,

		@Email
		String email,

		@NotBlank
		String password,

		@NotNull
		Gender gender,

		@NotNull
		LocalDate birth,

		@NotNull
		Address address,

		@NotNull
		String detailAddress,

		@NotNull
		String phoneNum
	){}
}
