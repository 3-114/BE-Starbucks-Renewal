package com.team114.starbucks.domain.member.presentation;

import com.team114.starbucks.domain.member.application.MemberServiceImpl;
import com.team114.starbucks.domain.member.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.member.dto.out.SignUpResponseDto;
import com.team114.starbucks.domain.member.vo.in.SignUpRequestVo;
import com.team114.starbucks.domain.member.vo.out.SignUpResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberServiceImpl memberService;

    /**
     * api/v1/member
     * 1. 회원가입
     * 2. 로그인
     */

    /**
     * 회원가입
     * @param signUpRequestVo
     */
    @PostMapping("/auth-service/sign-up")
    public SignUpResponseVo signUp(
            @RequestBody SignUpRequestVo signUpRequestVo
    ) {
        SignUpResponseDto result = memberService.signUp(SignUpRequestDto.from(signUpRequestVo));
        return result.toVo();
    }
}
