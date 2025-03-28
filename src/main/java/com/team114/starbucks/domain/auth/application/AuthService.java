package com.team114.starbucks.domain.auth.application;

import com.team114.starbucks.domain.auth.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.auth.dto.out.SignUpResponseDto;

public interface AuthService {

    /**
     * 1. 회원가입
     */

    /**
     * 1. 회원가입
     * @param signUpRequestDto
     */
    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);
}
