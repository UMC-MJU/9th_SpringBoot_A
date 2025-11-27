package com.example.umc9th.domain.mission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {
	@Query("""
	SELECT m
	FROM Mission m
	JOIN FETCH m.missionMembers mm
	JOIN FETCH m.shop
	WHERE mm.member.id = :memberId
	AND mm.status = :status
	AND mm.id < :cursor
	ORDER BY mm.updatedAt DESC, mm.createdAt DESC
	LIMIT :count
""")
	List<Mission> findMissionsByMissionStatus(MissionStatus status, long memberId, long cursor, long count);

	@Query("""
	SELECT m
    FROM Mission m
    JOIN FETCH m.shop s
    JOIN FETCH s.location l
    WHERE l.id = :locationId
	AND NOT EXISTS (
        SELECT 1
        FROM MissionMember mm
        WHERE mm.member.id = :memberId
        AND mm.mission = m
    )
	AND m.id < :cursor
	ORDER BY m.createdAt DESC, m.id DESC
	LIMIT :count
""")
	List<Mission> findAvailableMissionsByLocation(long locationId, long memberId, long cursor, long count);

	boolean existsByMinAmountAndRewardAndShopId(long minAmount, long reward, long shopId);

	@Query("""
	SELECT m
	FROM Mission m
	WHERE m.shop.id = :shopId
	AND (:cursor = 0 OR m.id < :cursor)
	ORDER BY m.updatedAt DESC, m.createdAt DESC
	LIMIT :count
""")
	List<Mission> findAllByShopId(long shopId, long cursor, long count);
}
