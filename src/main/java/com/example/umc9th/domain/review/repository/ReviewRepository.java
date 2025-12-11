package com.example.umc9th.domain.review.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {
	List<Review> findAllByMemberId(long memberId, PageRequest pageRequest);
}
