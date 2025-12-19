package com.example.umc9th.domain.member.service.command;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.req.MemberReqDto;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.global.auth.enums.Role;
import com.example.umc9th.global.entity.Location;
import com.example.umc9th.global.exception.LocationException;
import com.example.umc9th.global.exception.code.LocationErrorCode;
import com.example.umc9th.global.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

	private final LocationRepository locationRepository;
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void signup(MemberReqDto.JoinDto dto) {
		Location location = locationRepository.findByAddress(dto.address())
			.orElseThrow(() -> new LocationException(LocationErrorCode.BAD_REQUEST));

		String salt = passwordEncoder.encode(dto.password());

		Member member = MemberConverter.toMember(dto, salt, Role.ROLE_USER, location);

		memberRepository.save(member);
	}
}
