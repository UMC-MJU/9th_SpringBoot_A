package com.example.umc9th.global.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.global.auth.entity.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(
		String username
	) throws UsernameNotFoundException {
		// 검증할 Member 조회
		Member member = memberRepository.findByEmail(username)
			.orElseThrow(() -> new MemberException(MemberErrorCode.BAD_REQUEST));
		// CustomUserDetails 반환
		return new CustomUserDetails(member);
	}
}

