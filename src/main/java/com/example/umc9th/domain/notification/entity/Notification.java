package com.example.umc9th.domain.notification.entity;

import java.util.List;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.notification.entity.mapping.InquiryAnswer;
import com.example.umc9th.domain.notification.entity.mapping.NewMission;
import com.example.umc9th.domain.notification.entity.mapping.RequestReview;
import com.example.umc9th.domain.notification.entity.mapping.ReviewReply;
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
@Table(name = "notification")
public class Notification extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_read", nullable = false)
	@Builder.Default
	private Boolean isRead = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "notification", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<InquiryAnswer> inquiryAnswers;

	@OneToMany(mappedBy = "notification", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<ReviewReply> reviewReplies;

	@OneToMany(mappedBy = "notification", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<RequestReview> requestReviews;

	@OneToMany(mappedBy = "notification", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<NewMission> newMissions;
}
