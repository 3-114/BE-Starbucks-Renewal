package com.team114.starbucks.domain.member.presentation;

import com.team114.starbucks.domain.auth.userDetails.CustomUserDetails;
import com.team114.starbucks.domain.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/members")
@Slf4j
public class MemberController {

//    private final MemberService memberService;

    /**
     * 1. 비밀번호 변경
     * 2. 이메일 찾기
     * 3. 이메일 중복 체크
     */

    /**
     * 1. 비밀번호 변경
     */
    @PutMapping
    public Void updatePassword(Authentication authentication, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        log.info(customUserDetails.toString());
        log.info(authentication.toString());
        log.info(authentication.getPrincipal().toString());

        return null;
    }
}
