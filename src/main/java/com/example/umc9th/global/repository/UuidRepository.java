package com.example.umc9th.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.global.entity.Uuid;

public interface UuidRepository extends JpaRepository<Uuid, Long> {
}
