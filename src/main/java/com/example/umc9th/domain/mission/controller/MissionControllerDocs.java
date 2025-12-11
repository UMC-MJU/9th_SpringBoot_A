package com.example.umc9th.domain.mission.controller;

import java.util.List;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.mission.annotation.ExistMissions;
import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.dto.res.MissionResDto;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.shop.annotation.ExistShops;
import com.example.umc9th.global.annotation.OverZeroInteger;
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

	@Operation(
		summary = "특정 가게의 미션 조회 API",
		description = "특정 가게에 등록된 모든 미션을 조회합니다.페이지네이션으로 제공"
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<List<MissionResDto.MissionInShop>> findMissionByShop(
		@ExistShops long shopId,
		long cursor,
		long count
	);

	@Operation(
		summary = "특정 사용자가 진행중인 미션 조회 API",
		description = "특정 사용자가 진행중인 모든 미션을 조회합니다.페이지네이션으로 제공"
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<List<MissionResDto.MyMission>> findMyMission(
		@ExistMembers long memberId,
		MissionStatus status,
		@OverZeroInteger Integer page
	);
}
