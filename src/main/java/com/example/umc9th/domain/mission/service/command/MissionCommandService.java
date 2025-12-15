package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.dto.res.MissionResDto;

public interface MissionCommandService {
	void createMission(MissionReqDto.CreateMission missionReqDto);

	void challengeMission(long missionId, long memberId);

	MissionResDto.CompleteMission completeMission(long memberId, long memberMissionId);
}
