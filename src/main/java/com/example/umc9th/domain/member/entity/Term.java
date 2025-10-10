package com.example.umc9th.domain.member.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.example.umc9th.domain.member.entity.mapping.TermMember;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "term")
public class Term {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "required", nullable = false)
	private Boolean required;

	@CreatedDate
	@Column(name = "created_at", columnDefinition = "DATETIME(6)", nullable = false)
	private LocalDateTime created_at;

	@OneToOne(mappedBy = "term", fetch = FetchType.LAZY)
	private TermVersion termVersion;

	@OneToMany(mappedBy = "term", fetch = FetchType.LAZY)
	private List<TermMember> termMembers;
}
