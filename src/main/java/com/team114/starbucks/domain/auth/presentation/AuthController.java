package com.team114.starbucks.domain.auth.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.auth.application.AuthServiceImpl;
import com.team114.starbucks.domain.auth.dto.in.GetSignInReqDto;
import com.team114.starbucks.domain.auth.dto.in.CreateSignUpReqDto;
import com.team114.starbucks.domain.auth.vo.in.GetSignInReqVo;
import com.team114.starbucks.domain.auth.vo.in.CreateSignUpReqVo;
import com.team114.starbucks.domain.auth.vo.out.GetSignInResVo;
import com.team114.starbucks.domain.auth.vo.out.CreateSignUpResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth-service")
public class AuthController {

    private final AuthServiceImpl memberService;

    /**
     * 1. 회원가입
     * 2. 로그인
     */

    /**
     * 1. 회원가입
     *
     * @param createSignUpReqVo 회원가입 정보
     * @return {@link BaseResponseEntity} 회원가입 결과 닉네임
     */
    @Operation(summary = "회원가입", tags = {"Auth"})
    @PostMapping("/sign-up")
    public BaseResponseEntity<CreateSignUpResVo> signUp(
            @RequestBody CreateSignUpReqVo createSignUpReqVo
    ) {
        CreateSignUpResVo result = memberService.signUp(CreateSignUpReqDto.from(createSignUpReqVo)).toVo();
        return new BaseResponseEntity<>("회원가입에 성공하였습니다.", result);
    }

    /**
     * 2. 로그인
     *
     * @param getSignInReqVo 로그인 정보
     * @return {@link BaseResponseEntity} 로그인 결과
     */
    @Operation(summary = "로그인", tags = {"Auth"})
    @PostMapping("/sign-in")
    public BaseResponseEntity<GetSignInResVo> signIn(
            @RequestBody GetSignInReqVo getSignInReqVo
    ) {
        GetSignInResVo result = memberService.signIn(GetSignInReqDto.from(getSignInReqVo)).toVo();
        return new BaseResponseEntity<>("로그인에 성공하였습니다.", result);
    }
}
