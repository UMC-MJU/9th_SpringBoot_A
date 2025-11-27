package com.example.umc9th.domain.shop.controller;

import com.example.umc9th.domain.shop.dto.req.ShopReqDto;
import com.example.umc9th.global.apiPayload.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

public interface ShopControllerDocs {

	@Operation(
		summary = "가게 등록 API",
		description = "새 가게 정보를 등록합니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<Void> createShop(
		@Valid ShopReqDto.CreateShop shopReqDto
	);
}
