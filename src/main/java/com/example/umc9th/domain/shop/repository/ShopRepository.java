package com.example.umc9th.domain.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.umc9th.domain.shop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	boolean existsByBaseAddressAndDetailAddress(String baseAddress, String detailAddress);
}
