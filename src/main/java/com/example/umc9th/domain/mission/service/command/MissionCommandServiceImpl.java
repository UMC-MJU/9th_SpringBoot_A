package com.example.umc9th.domain.mission.service.command;

import org.springframework.stereotype.Service;

import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.shop.entity.Shop;
import com.example.umc9th.domain.shop.exception.ShopException;
import com.example.umc9th.domain.shop.exception.code.ShopErrorCode;
import com.example.umc9th.domain.shop.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

	private final MissionRepository missionRepository;
	private final ShopRepository shopRepository;

	@Override
	public void createMission(MissionReqDto.CreateMission missionReqDto) {
		Shop shop = shopRepository.findById(missionReqDto.getShopId())
			.orElseThrow(() -> new ShopException(ShopErrorCode.BAD_REQUEST));

		boolean isExist = missionRepository
			.existsByMinAmountAndRewardAndShopId(missionReqDto.getMinAmount(), missionReqDto.getReward(), shop.getId());

		if (isExist) {
			throw new MissionException(MissionErrorCode.EXIST_MISSION);
		}

		Mission mission = missionReqDto.toEntity(shop);
		missionRepository.save(mission);
	}
}
