package com.example.umc9th.domain.mission.exception.code;

import org.springframework.http.HttpStatus;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

	CREATED(HttpStatus.CREATED,
		"MISSION201",
		"미션 정보를 성공적으로 추가했습니다."),
	OK(HttpStatus.OK,
		"MISSION200",
		"성공적으로 미션 관련 요청을 처리했습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
