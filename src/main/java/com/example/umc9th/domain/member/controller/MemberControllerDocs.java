package com.example.umc9th.domain.member.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.umc9th.domain.member.dto.req.MemberReqDto;
import com.example.umc9th.domain.member.dto.res.MemberResDto;
import com.example.umc9th.global.apiPayload.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

public interface MemberControllerDocs {

	@Operation(
		summary = "회원 등록 API",
		description = "새 회원 정보를 등록합니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<Void> createMember(
		@Valid MemberReqDto.JoinDto memberReqDto
	);

	@Operation(
		summary = "로그인 API",
		description = "이메일, 비밀번호로 로그인하여 Access Token을 발급받습니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "로그인 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	@PostMapping("/login")
	ApiResponse<MemberResDto.LoginDto> login(
		@Valid MemberReqDto.LoginDto dto
	);
}
