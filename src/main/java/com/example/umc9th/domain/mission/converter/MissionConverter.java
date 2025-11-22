package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MissionMember;
import com.example.umc9th.domain.shop.entity.Shop;

public class MissionConverter {

	public static MissionMember toMissionMember(Mission mission, Member member) {
		return MissionMember.builder()
			.mission(mission)
			.member(member)
			.build();
	}

	public static Mission toMission(MissionReqDto.CreateMission missionReqDto, Shop shop) {
		return missionReqDto.toEntity(shop);
	}
}
