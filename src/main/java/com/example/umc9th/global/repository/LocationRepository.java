package com.example.umc9th.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.global.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
