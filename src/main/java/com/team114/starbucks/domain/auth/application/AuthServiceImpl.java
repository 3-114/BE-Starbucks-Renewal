package com.team114.starbucks.domain.auth.application;

import com.team114.starbucks.common.jwt.JwtTokenProvider;
import com.team114.starbucks.domain.auth.dto.in.SignInRequestDto;
import com.team114.starbucks.domain.auth.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.auth.dto.out.SignInResponseDto;
import com.team114.starbucks.domain.auth.dto.out.SignUpResponseDto;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        // 패스워드 암호화
        String password = passwordEncoder.encode(signUpRequestDto.getPassword());

        // dto -> entity
        Member member = signUpRequestDto.toEntity(password);

        // 레포지토리에 저장
        memberRepository.save(member);

        // entity -> dto
        return SignUpResponseDto.from(member);
    }

    @Transactional
    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {

        // todo[4] : 예외처리 커스터마이징
        Member member = memberRepository.findByEmail(signInRequestDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("아이디 또는 패스워드를 다시 확인하세요."));

        String accessToken = createToken(authenticate(member, signInRequestDto.getPassword()));

        return SignInResponseDto.from(member, accessToken);
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
