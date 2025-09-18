package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query(value = "SELECT * " +
            "FROM member " +
            "WHERE name = :name AND deleted_at IS NULL", nativeQuery = true)
    List<Member> findActiveMember(@Param("name") String name);
}
