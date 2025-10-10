package com.example.umc9th.domain.inquiry.entity;

import java.util.List;

import com.example.umc9th.domain.inquiry.enums.InquiryStatus;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "inquiry")
public class Inquiry extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 30, nullable = false)
	private String title;

	@Column(name = "content", length = 255, nullable = false)
	private String content;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private InquiryStatus status = InquiryStatus.WAITING;

	@Column(name = "answer", length = 255)
	private String answer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "inquiry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<InquiryImage> inquiryImages;
}
