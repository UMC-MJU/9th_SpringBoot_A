package com.example.umc9th.domain.review.entity;

import java.math.BigDecimal;
import java.util.List;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.shop.entity.Shop;
import com.example.umc9th.global.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "review")
public class Review extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "score", precision = 2, scale = 1, nullable = false)
	private BigDecimal score;

	@Column(name = "content", length = 255, nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@OneToMany(mappedBy = "review", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<ReviewImage> reviewImages;

	@OneToOne(mappedBy = "review", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Reply reply;
}
