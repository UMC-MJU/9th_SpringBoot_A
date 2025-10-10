package com.example.umc9th.domain.member.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.MemberStatus;
import com.example.umc9th.global.entity.BaseEntity;
import com.example.umc9th.global.entity.Location;

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
@Table(name = "member")
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 15, nullable = false)
	private String name;

	@Column(name = "nickname", length = 15, nullable = false)
	private String nickname;

	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private Gender gender = Gender.NONE;

	@Column(name = "birth", nullable = false)
	private LocalDate birth;

	@Column(name = "detail_address", length = 100, nullable = false)
	private String detailAddress;

	@Column(name = "point", nullable = false)
	@Builder.Default
	private Integer point = 0;

	@Column(name = "phone_num", length = 11, nullable = false)
	private String phoneNum;

	@Column(name = "email", length = 255, nullable = false)
	private String email;

	@Column(name = "phone_certificated", nullable = false)
	private Boolean phone_certificated;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private MemberStatus status = MemberStatus.INACTIVE;

	@Column(name = "inactive_date", nullable = false)
	private LocalDateTime inactiveDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;
}
