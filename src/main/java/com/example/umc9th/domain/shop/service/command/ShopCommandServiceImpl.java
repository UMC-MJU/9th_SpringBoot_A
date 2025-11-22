package com.example.umc9th.domain.shop.service.command;

import org.springframework.stereotype.Service;

import com.example.umc9th.domain.shop.converter.ShopConverter;
import com.example.umc9th.domain.shop.dto.req.ShopReqDto;
import com.example.umc9th.domain.shop.entity.Shop;
import com.example.umc9th.domain.shop.exception.ShopException;
import com.example.umc9th.domain.shop.exception.code.ShopErrorCode;
import com.example.umc9th.domain.shop.repository.ShopRepository;
import com.example.umc9th.global.entity.Location;
import com.example.umc9th.global.exception.LocationException;
import com.example.umc9th.global.exception.code.LocationErrorCode;
import com.example.umc9th.global.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopCommandServiceImpl implements ShopCommandService {

	private final ShopRepository shopRepository;
	private final LocationRepository locationRepository;

	@Override
	public void createShop(ShopReqDto.CreateShop shopReqDto) {
		Location location = locationRepository.findById(shopReqDto.getLocationId())
			.orElseThrow(() -> new LocationException(LocationErrorCode.BAD_REQUEST));

		boolean isExist = shopRepository
			.existsByBaseAddressAndDetailAddress(shopReqDto.getBaseAddress(), shopReqDto.getDetailAddress());

		if (isExist) {
			throw new ShopException(ShopErrorCode.EXIST_SHOP_ADDRESS);
		}

		Shop shop = ShopConverter.toShop(shopReqDto, location);
		shopRepository.save(shop);
	}
}
