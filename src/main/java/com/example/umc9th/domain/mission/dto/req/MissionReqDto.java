package com.example.umc9th.domain.mission.dto.req;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.shop.annotation.ExistShops;
import com.example.umc9th.domain.shop.entity.Shop;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionReqDto {

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateMission {

		@Min(10)
		private int minAmount;

		@Min(10)
		private int reward;

		@ExistShops
		private long shopId;

		public Mission toEntity(Shop shop) {
			return Mission.builder()
				.minAmount(minAmount)
				.reward(reward)
				.shop(shop)
				.build();
		}
	}
}
