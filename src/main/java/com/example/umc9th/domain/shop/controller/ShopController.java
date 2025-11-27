package com.example.umc9th.domain.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.shop.dto.req.ShopReqDto;
import com.example.umc9th.domain.shop.exception.code.ShopSuccessCode;
import com.example.umc9th.domain.shop.service.command.ShopCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController implements ShopControllerDocs{

	private final ShopCommandService shopCommandService;

	@Override
	@PostMapping
	public ApiResponse<Void> createShop(
		@RequestBody @Valid ShopReqDto.CreateShop shopReqDto
	) {
		shopCommandService.createShop(shopReqDto);

		ShopSuccessCode code = ShopSuccessCode.CREATED;
		return ApiResponse.onSuccess(
			code,
			null
		);
	}
}
