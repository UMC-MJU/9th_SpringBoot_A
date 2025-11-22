package com.example.umc9th.domain.shop.dto.req;

import com.example.umc9th.domain.shop.entity.Shop;
import com.example.umc9th.global.annotation.ExistLocation;
import com.example.umc9th.global.entity.Location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ShopReqDto {

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateShop {

		@NotBlank
		@Size(max = 30, message = "가게 이름은 30자 이하여야 합니다.")
		private String name;

		@NotBlank
		@Size(max = 150, message = "가게 기본 주소는 150자 이하여야 합니다.")
		private String baseAddress;

		@NotBlank
		@Size(max = 100, message = "가게 상세 주소는 100자 이하여야 합니다.")
		private String detailAddress;

		@ExistLocation
		private long locationId;

		public Shop toEntity(Location location) {
			return Shop.builder()
				.name(name)
				.baseAddress(baseAddress)
				.detailAddress(detailAddress)
				.location(location)
				.build();
		}
	}
}
