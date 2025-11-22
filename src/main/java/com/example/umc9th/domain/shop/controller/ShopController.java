package com.example.umc9th.domain.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.shop.dto.req.ShopReqDto;
import com.example.umc9th.domain.shop.service.command.ShopCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

	private final ShopCommandService shopCommandService;

	@PostMapping
	public ApiResponse<Void> createShop(
		@RequestBody @Valid ShopReqDto.CreateShop shopReqDto
	) {
		shopCommandService.createShop(shopReqDto);

		GeneralSuccessCode code = GeneralSuccessCode.CREATED;
		return ApiResponse.onSuccess(
			code,
			null
		);
	}
}
