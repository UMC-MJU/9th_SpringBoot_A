package com.example.umc9th.domain.mission.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.mission.annotation.ExistMissions;
import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController implements MissionControllerDocs{

	private final MissionCommandService missionCommandService;

	@Override
	@PostMapping
	public ApiResponse<Void> createMission(
		@RequestBody @Valid MissionReqDto.CreateMission missionReqDto
	) {
		missionCommandService.createMission(missionReqDto);

		GeneralSuccessCode code = GeneralSuccessCode.CREATED;
		return ApiResponse.onSuccess(
			code,
			null
		);
	}

	@Override
	@PostMapping("/challenge")
	public ApiResponse<Void> challengeMission(
		@RequestParam("memberId") @ExistMembers long memberId,
		@RequestParam("missionId") @ExistMissions long missionId
	) {
		missionCommandService.challengeMission(missionId, memberId);

		GeneralSuccessCode code = GeneralSuccessCode.CREATED;
		return ApiResponse.onSuccess(
			code,
			null
		);
	}
}
