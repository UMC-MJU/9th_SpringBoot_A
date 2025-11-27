package com.example.umc9th.domain.mission.dto.res;

import com.example.umc9th.domain.mission.entity.Mission;

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
}
