package com.example.umc9th.domain.mission.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MissionMember;
import com.example.umc9th.domain.mission.enums.MissionStatus;

public interface MissionMemberRepository extends JpaRepository<MissionMember, Long> {
	boolean existsByMissionAndMember(Mission mission, Member member);

	List<MissionMember> findAllByMemberIdAndStatus(long memberId, MissionStatus status, PageRequest pageRequest);
}
