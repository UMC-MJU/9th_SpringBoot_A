package com.example.umc9th.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findMemberById(long id);
}
