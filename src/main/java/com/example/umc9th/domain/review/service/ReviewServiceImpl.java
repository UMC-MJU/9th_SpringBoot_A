package com.example.umc9th.domain.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.res.ReviewResDto;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewRepository reviewRepository;

	@Override
	public List<ReviewResDto.Searching> searchReview(
		long memberId,
		String type,
		String query
	) {
		QReview review = QReview.review;

		BooleanBuilder builder = new BooleanBuilder();

		builder.and(review.member.id.eq(memberId));
		if (type.equals("shop")) {
			builder.and(review.shop.name.contains(query));
		}
		if (type.equals("rating")) {
			float rating = Float.parseFloat(query);
			builder.and(review.score.between(rating, rating+1));
		}

		List<Review> reviewList = reviewRepository.searchReview(builder);

		return reviewList.stream()
			.map(ReviewConverter::toSearchingDto)
			.toList();
	}
}
