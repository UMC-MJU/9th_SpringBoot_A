package com.example.umc9th.domain.mission.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "MISSION400_1", "해당하는 미션을 찾을 수 없습니다."),
	EXIST_MISSION(HttpStatus.BAD_REQUEST, "MISSION400_2", "이미 같은 미션이 존재합니다."),
	EXIST_CHALLENGED_MISSION(HttpStatus.BAD_REQUEST, "MISSION400_3", "이미 도전 중인 미션입니다."),
	NOT_EXIST_CHALLENGED_MISSION(HttpStatus.BAD_REQUEST, "MISSION400_4", "도전 중인 미션이 존재하지 않습니다."),
	INVALID_MISSION_LOCATION(HttpStatus.BAD_REQUEST, "MISSION400_5", "다른 지역에 있는 가게의 미션은 도전할 수 없습니다."),
	INVALID_MEMBER_CHALLENGED_MISSION(HttpStatus.BAD_REQUEST, "MISSION400_6", "자신이 도전중인 미션만 완료시킬 수 있습니다."),
	ALREADY_COMPLETED_MISSION(HttpStatus.BAD_REQUEST, "MISSION400_7", "이미 도전 완료 상태인 미션입니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
