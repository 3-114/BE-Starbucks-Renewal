package com.team114.starbucks.domain.auth.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.auth.application.AuthServiceImpl;
import com.team114.starbucks.domain.auth.dto.in.SignInRequestDto;
import com.team114.starbucks.domain.auth.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.auth.vo.in.SignInRequestVo;
import com.team114.starbucks.domain.auth.vo.in.SignUpRequestVo;
import com.team114.starbucks.domain.auth.vo.out.SignInResponseVo;
import com.team114.starbucks.domain.auth.vo.out.SignUpResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
     * api/v1/member
     * 1. 회원가입
     * 2. 로그인
     */

    /**
     * 회원가입
     * @param signUpRequestVo
     */
    @Operation(summary = "sign-up API", description = "회원가입 API 입니다.", tags = {"auth-service"})
    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponseEntity<SignUpResponseVo>> signUp(
            @RequestBody SignUpRequestVo signUpRequestVo
    ) {
        SignUpResponseVo result = memberService.signUp(SignUpRequestDto.from(signUpRequestVo)).toVo();
        return ResponseEntity.ok(new BaseResponseEntity<>("회원가입에 성공하였습니다.", result));
    }

    /**
     * 로그인
     * @param signInRequestVo
     * @Return signInResponseVo
     */
    @Operation(summary = "sign-in API", description = "로그인 API 입니다.", tags = {"auth-service"})
    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponseEntity<SignInResponseVo>> signIn(
            @RequestBody SignInRequestVo signInRequestVo
    ) {
        SignInResponseVo result = memberService.signIn(SignInRequestDto.from(signInRequestVo)).toVo();
        return ResponseEntity.ok(new BaseResponseEntity<>("로그인에 성공하였습니다.", result));
    }
}
