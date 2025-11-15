package com.example.umc9th.domain.review.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;

	@GetMapping("/reviews/search")
	public ApiResponse<List<ReviewResDto.Searching>> searchReview(
		@RequestParam("member-id") long memberId,
		@RequestParam("type")String type,
		@RequestParam("query")String query
	) {
		GeneralSuccessCode code = GeneralSuccessCode.OK;
		return ApiResponse.onSuccess(
			code,
			reviewService.searchReview(memberId, type, query)
		);

	}
}
