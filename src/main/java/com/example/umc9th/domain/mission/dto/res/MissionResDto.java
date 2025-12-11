package com.example.umc9th.domain.mission.dto.res;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MissionMember;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class MissionResDto {

	@Getter
	@Builder
	@RequiredArgsConstructor
	public static class MissionInShop {
		private final String shopName;
		private final Integer minAmount;
		private final Integer reward;

		public static MissionInShop from(Mission mission) {
			return MissionInShop.builder()
				.shopName(mission.getShop().getName())
				.minAmount(mission.getMinAmount())
				.reward(mission.getReward())
				.build();
		}
	}

	@Getter
	@Builder
	@RequiredArgsConstructor
	public static class MyMission {
		private final String missionStatus;
		private final String shopName;
		private final Integer minAmount;
		private final Integer reward;

		public static MyMission from(MissionMember missionMember) {
			return MyMission.builder()
				.missionStatus(missionMember.getStatus().toString())
				.shopName(missionMember.getMission().getShop().getName())
				.minAmount(missionMember.getMission().getMinAmount())
				.reward(missionMember.getMission().getReward())
				.build();
		}
	}
}
