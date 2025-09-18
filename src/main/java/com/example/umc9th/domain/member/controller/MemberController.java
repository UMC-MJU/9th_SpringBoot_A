package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.service.query.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/query-test")
    public String queryTest(
            @RequestParam String name
    ){
        return memberQueryService.QueryTest(name);
    }
}
