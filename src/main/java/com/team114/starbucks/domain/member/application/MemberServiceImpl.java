package com.team114.starbucks.domain.member.application;

import com.team114.starbucks.domain.member.dto.in.SignInRequestDto;
import com.team114.starbucks.domain.member.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.member.dto.out.SignUpResponseDto;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        // dto -> entity
        Member member = signUpRequestDto.toEntity();

        // 레포지토리에 저장
        memberRepository.save(member);

        // entity -> dto
        return SignUpResponseDto.from(member);
    }

    @Transactional
    @Override
    public void signIn(SignInRequestDto signInRequestDto) {

        Member member = memberRepository.findByEmail(signInRequestDto.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String memberUuid) {
        return memberRepository.findByMemberUuid(memberUuid)
                // Todo[1] : 예외처리 커스텀하기
                .orElseThrow(() -> new IllegalArgumentException(memberUuid));
    }
}
