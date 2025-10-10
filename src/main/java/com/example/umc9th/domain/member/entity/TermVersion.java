package com.example.umc9th.domain.member.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "term_version")
public class TermVersion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "version", nullable = false)
	private Integer version;

	@Column(name = "title", length = 255, nullable = false)
	private String title;

	@Lob
	private String content;

	@CreatedDate
	@Column(name = "created_at", columnDefinition = "DATETIME(6)", nullable = false)
	private LocalDateTime created_at;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "term_id")
	private Term term;
}
