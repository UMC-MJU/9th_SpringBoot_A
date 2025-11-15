package com.example.umc9th.domain.review.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewQueryService reviewQueryService;

	@GetMapping("/search")
	public ApiResponse<List<ReviewResDto.Searching>> searchReview(
		@RequestParam("member-id") long memberId,
		@RequestParam("type")String type,
		@RequestParam("query")String query
	) {
		GeneralSuccessCode code = GeneralSuccessCode.OK;
		return ApiResponse.onSuccess(
			code,
			reviewQueryService.searchReview(memberId, type, query)
		);

	}

	@GetMapping("/exception")
	public ApiResponse<ReviewResDto.Exception> exception(
		@RequestParam Long flag
	) {
		reviewQueryService.checkFlag(flag);

		GeneralSuccessCode code = GeneralSuccessCode.OK;
		return ApiResponse.onSuccess(code, ReviewConverter.toExceptionDTO("This is Test!"));
	}
}
