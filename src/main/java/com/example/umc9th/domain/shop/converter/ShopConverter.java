package com.example.umc9th.domain.shop.converter;

import com.example.umc9th.domain.shop.dto.req.ShopReqDto;
import com.example.umc9th.domain.shop.entity.Shop;
import com.example.umc9th.global.entity.Location;

public class ShopConverter {

	public static Shop toShop(ShopReqDto.CreateShop shopReqDto, Location location) {
		return shopReqDto.toEntity(location);
	}
}
