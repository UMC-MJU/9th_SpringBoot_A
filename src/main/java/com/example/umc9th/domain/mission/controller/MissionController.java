package com.example.umc9th.domain.mission.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

	private final MissionCommandService missionCommandService;

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
}
