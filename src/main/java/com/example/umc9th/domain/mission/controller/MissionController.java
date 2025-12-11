package com.example.umc9th.domain.mission.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.mission.annotation.ExistMissions;
import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.dto.res.MissionResDto;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.domain.shop.annotation.ExistShops;
import com.example.umc9th.global.annotation.OverZeroInteger;
import com.example.umc9th.global.apiPayload.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController implements MissionControllerDocs{

	private final MissionCommandService missionCommandService;
	private final MissionQueryService missionQueryService;

	@Override
	@PostMapping
	public ApiResponse<Void> createMission(
		@RequestBody @Valid MissionReqDto.CreateMission missionReqDto
	) {
		missionCommandService.createMission(missionReqDto);

		MissionSuccessCode code = MissionSuccessCode.CREATED;
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

		MissionSuccessCode code = MissionSuccessCode.CREATED;
		return ApiResponse.onSuccess(
			code,
			null
		);
	}

	@Override
	@GetMapping("/shops")
	public ApiResponse<List<MissionResDto.MissionInShop>> findMissionByShop(
		@RequestParam("shop-id") @ExistShops long shopId,
		@RequestParam(value = "cursor", defaultValue = "0", required = false) long cursor,
		@RequestParam(value = "count", defaultValue = "3", required = false) long count
	) {
		MissionSuccessCode code = MissionSuccessCode.OK;
		return ApiResponse.onSuccess(
			code,
			missionQueryService.findMissionByShop(shopId, cursor, count)
		);
	}

	@Override
	@GetMapping("/my")
	public ApiResponse<List<MissionResDto.MyMission>> findMyMission(
		@RequestParam("member-id") @ExistMembers long memberId,
		@RequestParam("status") MissionStatus status,
		@RequestParam(value = "page", defaultValue = "1") @OverZeroInteger Integer page
	) {
		MissionSuccessCode code = MissionSuccessCode.OK;
		return ApiResponse.onSuccess(
			code,
			missionQueryService.findMyMission(memberId, status, page)
		);
	}
}
