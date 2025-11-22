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
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
