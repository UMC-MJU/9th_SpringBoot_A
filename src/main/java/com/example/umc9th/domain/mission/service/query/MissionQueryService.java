package com.example.umc9th.domain.mission.service.query;

import java.util.List;

import com.example.umc9th.domain.mission.dto.res.MissionResDto;

public interface MissionQueryService {
	List<MissionResDto.MissionInShop> findMissionByShop(long shopId, long cursor, long count);
}
