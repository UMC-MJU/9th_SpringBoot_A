package com.example.umc9th.domain.mission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {
	@Query("""
	SELECT m
	FROM MissionMember mm
	JOIN FETCH mm.mission m
	JOIN FETCH m.shop
	WHERE mm.member.id = :memberId
	AND mm.status = :status
	AND mm.id < :cursor
	ORDER BY mm.updatedAt DESC, mm.createdAt DESC
	LIMIT :count
""")
	List<Mission> findMissionsByMissionStatus(MissionStatus status, long memberId, long cursor, long count);
}
