package com.team114.starbucks.domain.member.application;

import com.team114.starbucks.domain.member.dto.in.SignInRequestDto;
import com.team114.starbucks.domain.member.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.member.dto.out.SignUpResponseDto;
import com.team114.starbucks.domain.member.vo.in.SignUpRequestVo;
import com.team114.starbucks.domain.member.vo.out.SignUpResponseVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService {

    /**
     * 1. 회원가입
     * 2. 로그인
     * 3. loadUserByUsername
     */

    /**
     * 1. 회원가입
     * @param signUpRequestDto
     */
    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto);

    /**
     * 2. 로그인
     * @param signInRequestDto
     */
    void signIn(SignInRequestDto signInRequestDto);

    /**
     * 3. loadUserByUsername
     */
    UserDetails loadUserByUsername(String memberUuid);
}
