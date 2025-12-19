package com.example.umc9th.global.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.global.entity.Location;
import com.example.umc9th.global.enums.Address;

public interface LocationRepository extends JpaRepository<Location, Long> {
	Optional<Location> findByAddress(Address address);
}
