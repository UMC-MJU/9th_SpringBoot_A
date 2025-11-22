package com.example.umc9th.domain.shop.service.command;

import com.example.umc9th.domain.shop.dto.req.ShopReqDto;

public interface ShopCommandService {
	void createShop(ShopReqDto.CreateShop shopReqDto);
}
