package com.team114.starbucks.domain.auth.application;

import com.team114.starbucks.domain.auth.dto.in.SignInRequestDto;
import com.team114.starbucks.domain.auth.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.auth.dto.out.SignInResponseDto;
import com.team114.starbucks.domain.auth.dto.out.SignUpResponseDto;

public interface AuthService {

    /**
     * 1. 회원가입
     * 2. 로그인
     * 3. loadByUsername
     */

    /**
     * 1. 회원가입
     * @param signUpRequestDto
     */
    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

    /**
     * 2. 로그인
     * @param signInRequestDto
     * @return
     */
    SignInResponseDto signIn(SignInRequestDto signInRequestDto);

}