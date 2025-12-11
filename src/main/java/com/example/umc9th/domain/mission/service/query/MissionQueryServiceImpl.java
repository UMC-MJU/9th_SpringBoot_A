package com.example.umc9th.domain.mission.service.query;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.res.MissionResDto;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.repository.MissionMemberRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

	private final MissionRepository missionRepository;
	private final MissionMemberRepository missionMemberRepository;

	@Override
	public List<MissionResDto.MissionInShop> findMissionByShop(long shopId, long cursor, long count) {
		return missionRepository.findAllByShopId(shopId, cursor, count).stream()
			.map(MissionConverter::toMissionInShop)
			.toList();
	}

	@Override
	public List<MissionResDto.MyMission> findMyMission(long memberId, MissionStatus status, Integer page) {
		PageRequest pageRequest = PageRequest.of(page-1, 10);
		return missionMemberRepository.findAllByMemberIdAndStatus(memberId, status, pageRequest).stream()
			.map(MissionConverter::toMyMission)
			.toList();
	}
}
