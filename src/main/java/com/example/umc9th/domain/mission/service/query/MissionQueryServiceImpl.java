package com.example.umc9th.domain.mission.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.res.MissionResDto;
import com.example.umc9th.domain.mission.repository.MissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

	private final MissionRepository missionRepository;

	@Override
	public List<MissionResDto.MissionInShop> findMissionByShop(long shopId, long cursor, long count) {
		return missionRepository.findAllByShopId(shopId, cursor, count).stream()
			.map(MissionConverter::toMissionInShop)
			.toList();
	}
}
