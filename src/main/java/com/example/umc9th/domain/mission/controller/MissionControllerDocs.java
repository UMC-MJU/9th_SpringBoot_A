package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.mission.annotation.ExistMissions;
import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.global.apiPayload.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

public interface MissionControllerDocs {

	@Operation(
		summary = "미션 등록 API",
		description = "특정 가게에 새 미션을 등록합니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<Void> createMission(
		@Valid MissionReqDto.CreateMission missionReqDto
	);

	@Operation(
		summary = "미션 도전 API",
		description = "특정 사용자가 특정 가게의 미션을 도전하는 미션에 추가합니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<Void> challengeMission(
		@ExistMembers long memberId,
		@ExistMissions long missionId
	);
}
