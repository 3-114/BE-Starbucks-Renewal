package com.team114.starbucks.domain.member.application;

import com.team114.starbucks.domain.member.dto.in.SignUpRequestDto;
import com.team114.starbucks.domain.member.dto.out.SignUpResponseDto;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
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
}
