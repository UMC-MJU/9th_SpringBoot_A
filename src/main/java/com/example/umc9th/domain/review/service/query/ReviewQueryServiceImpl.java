package com.example.umc9th.domain.review.service.query;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
	private final ReviewRepository reviewRepository;

	@Transactional(readOnly = true)
	@Override
	public List<ReviewResDto.Searching> searchReview(
		long memberId,
		String type,
		String query
	) {
		List<Review> reviewList = reviewRepository.searchReview(memberId, type, query);

		return reviewList.stream()
			.map(ReviewConverter::toSearchingDto)
			.toList();
	}

	@Override
	public void checkFlag(Long flag) {
		if (flag == 1) {
			throw new ReviewException(ReviewErrorCode.TEST_EXCEPTION);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<ReviewResDto.MyReview> findReviewByMember(
		long memberId,
		Integer page
	) {
		PageRequest pageRequest = PageRequest.of(page-1, 10);
		List<Review> reviewList = reviewRepository.findAllByMemberId(memberId, pageRequest);

		return reviewList.stream()
			.map(ReviewConverter::toMyReviewDto)
			.toList();
	}
}
