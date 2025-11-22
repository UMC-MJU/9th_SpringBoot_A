package com.example.umc9th.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MissionMember;

public interface MissionMemberRepository extends JpaRepository<MissionMember, Long> {
	boolean existsByMissionAndMember(Mission mission, Member member);
}
