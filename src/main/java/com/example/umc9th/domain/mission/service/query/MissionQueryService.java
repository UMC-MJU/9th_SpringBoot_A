package com.example.umc9th.domain.mission.service.query;

import java.util.List;

import com.example.umc9th.domain.mission.dto.res.MissionResDto;
import com.example.umc9th.domain.mission.enums.MissionStatus;

public interface MissionQueryService {
	List<MissionResDto.MissionInShop> findMissionByShop(long shopId, long cursor, long count);

	List<MissionResDto.MyMission> findMyMission(long memberId, MissionStatus status, Integer page);
}
