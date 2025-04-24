package com.team114.starbucks.domain.auth.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.jwt.JwtTokenProvider;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.auth.dto.in.GetSignInReqDto;
import com.team114.starbucks.domain.auth.dto.in.CreateSignUpReqDto;
import com.team114.starbucks.domain.auth.dto.out.GetSignInResDto;
import com.team114.starbucks.domain.auth.dto.out.CreateSignUpResDto;
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
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public CreateSignUpResDto signUp(CreateSignUpReqDto createSignUpReqDto) {

        try {
            return CreateSignUpResDto.from(memberRepository.save(createSignUpReqDto.toEntity(
                                    passwordEncoder.encode(createSignUpReqDto.getPassword())))
            );
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_RESTORE);
        }
    }

    @Transactional
    @Override
    public GetSignInResDto signIn(GetSignInReqDto getSignInReqDto) {

        try {
            Member member = memberRepository.findByEmail(getSignInReqDto.getEmail())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_LOGIN));

            return GetSignInResDto.from(member, createToken(authenticate(member, getSignInReqDto.getPassword())).substring(7));
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }
    }

    public String createToken(Authentication authentication) {
        return jwtTokenProvider.generateAccessToken(authentication);
    }

    public Authentication authenticate(Member member, String inputPassword) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(member.getMemberUuid(),
                        inputPassword
                )
        );
    }
}
