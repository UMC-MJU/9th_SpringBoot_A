package com.example.umc9th.domain.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.member.dto.req.MemberReqDto;
import com.example.umc9th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc9th.domain.member.service.command.MemberCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController implements MemberControllerDocs{

	private final MemberCommandService memberCommandService;

	@Override
	@PostMapping("/signup")
	public ApiResponse<Void> createMember (
		@RequestBody @Valid MemberReqDto.JoinDto dto
	) {
		memberCommandService.signup(dto);

		MemberSuccessCode code = MemberSuccessCode.CREATED;
		return ApiResponse.onSuccess(
			code,
			null
		);
	}
}
