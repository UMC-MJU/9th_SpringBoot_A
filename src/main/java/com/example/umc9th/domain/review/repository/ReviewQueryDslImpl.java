package com.example.umc9th.domain.review.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl{
	private final EntityManager em;

	@Override
	public List<Review> searchReview(
		long memberId,
		String type,
		String query
	) {
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);

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

		return queryFactory
			.selectFrom(review)
			.where(builder)
			.fetch();
	}
}
