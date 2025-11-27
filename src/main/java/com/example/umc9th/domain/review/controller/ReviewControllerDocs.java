package com.example.umc9th.domain.review.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.umc9th.domain.member.annotation.ExistMembers;
import com.example.umc9th.domain.review.dto.req.ReviewReqDto;
import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.global.apiPayload.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

public interface ReviewControllerDocs {

	@Operation(
		summary = "리뷰 검색 API",
		description = "리뷰 목록을 특정 키워드 및 조건에 맞춰 조회합니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<List<ReviewResDto.Searching>> searchReview(
		@ExistMembers long memberId,
		String type,
		String query
	);

	@Operation(
		summary = "리뷰 등록 API",
		description = "새 리뷰 정보 및 이미지를 등록합니다."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<Void> createReview(
		@Valid ReviewReqDto.CreateReview reviewReqDto,
		List<MultipartFile> imageList
	);

	@Operation(
		summary = "작성한 리뷰 목록 조회 API",
		description = "본인이 작성한 리뷰 목록을 조회합니다.."
	)
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
	})
	ApiResponse<List<ReviewResDto.MyReview>> getMyReview(
		@ExistMembers long memberId
	);
}
