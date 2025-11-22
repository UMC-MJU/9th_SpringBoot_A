package com.example.umc9th.domain.mission.service.command;

import org.springframework.stereotype.Service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.req.MissionReqDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MissionMember;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionMemberRepository;
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
	private final MemberRepository memberRepository;
	private final MissionMemberRepository missionMemberRepository;

	@Override
	public void createMission(MissionReqDto.CreateMission missionReqDto) {
		Shop shop = shopRepository.findById(missionReqDto.getShopId())
			.orElseThrow(() -> new ShopException(ShopErrorCode.BAD_REQUEST));

		boolean isExist = missionRepository
			.existsByMinAmountAndRewardAndShopId(missionReqDto.getMinAmount(), missionReqDto.getReward(), shop.getId());

		if (isExist) {
			throw new MissionException(MissionErrorCode.EXIST_MISSION);
		}

		Mission mission = MissionConverter.toMission(missionReqDto, shop);
		missionRepository.save(mission);
	}

	@Override
	public void challengeMission(long missionId, long memberId) {
		Mission mission = missionRepository.findById(missionId)
			.orElseThrow(() -> new MissionException(MissionErrorCode.BAD_REQUEST));

		Member member = memberRepository.findMemberById(memberId)
			.orElseThrow(() -> new MemberException(MemberErrorCode.BAD_REQUEST));

		long missionLocationId = mission.getShop()
			.getLocation()
			.getId();

		long memberLocationId = member.getLocation()
			.getId();

		if (missionLocationId != memberLocationId) {
			throw new MissionException(MissionErrorCode.INVALID_MISSION_LOCATION);
		}

		boolean isExist = missionMemberRepository
			.existsByMissionAndMember(mission, member);

		if (isExist) {
			throw new MissionException(MissionErrorCode.EXIST_CHALLENGED_MISSION);
		}

		MissionMember missionMember = MissionConverter.toMissionMember(mission, member);
		missionMemberRepository.save(missionMember);
	}
}
