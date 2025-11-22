package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.req.MissionReqDto;

public interface MissionCommandService {
	void createMission(MissionReqDto.CreateMission missionReqDto);
}
