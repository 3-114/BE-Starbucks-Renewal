package com.team114.starbucks.domain.auth.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.jwt.JwtTokenProvider;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.auth.dto.in.SignInRequestDto;
import com.team114.starbucks.domain.auth.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.auth.dto.out.SignInResponseDto;
import com.team114.starbucks.domain.auth.dto.out.SignUpResponseDto;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        try {

            // 레포지토리에 저장
            Member member = memberRepository.save(
                    signUpRequestDto.toEntity(
                            passwordEncoder.encode(signUpRequestDto.getPassword())
                    )
            );

            // entity -> dto
            return SignUpResponseDto.from(member);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_RESTORE);
        }
    }

    @Transactional
    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {

        try {
            Member member = memberRepository.findByEmail(signInRequestDto.getEmail())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_LOGIN));

            return SignInResponseDto.from(member, createToken(authenticate(member, signInRequestDto.getPassword())));
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }
    }

    // 토큰 생성
    public String createToken(Authentication authentication) {
        return jwtTokenProvider.generateAccessToken(authentication);
    }

    // 인증 (진짜인지 확인)
    public Authentication authenticate(Member member, String inputPassword) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        member.getMemberUuid(),
                        inputPassword
                )
        );
    }
}
