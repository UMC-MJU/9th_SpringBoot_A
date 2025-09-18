package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.repository.MemberFoodRepository;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;
    private final MemberFoodRepository memberFoodRepository;

    public String QueryTest(
        String name
    ) {
        return memberRepository.findActiveMember(name).get(0).getName();
    }
}
