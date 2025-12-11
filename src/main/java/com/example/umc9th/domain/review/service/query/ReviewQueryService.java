package com.example.umc9th.domain.review.service.query;

import java.util.List;

import com.example.umc9th.domain.review.dto.res.ReviewResDto;

public interface ReviewQueryService {
	List<ReviewResDto.Searching> searchReview(long memberId, String type, String query);

	void checkFlag(Long flag);

	List<ReviewResDto.MyReview> findReviewByMember(long memberId, Integer page);
}
