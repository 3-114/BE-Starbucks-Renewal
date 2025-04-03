package com.team114.starbucks.domain.auth.dto.out;

import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.auth.vo.out.SignUpResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private String nickname;

    @Builder
    public SignUpResponseDto(String nickname) {
        this.nickname = nickname;
    }

    public static SignUpResponseDto from(Member member) {

        return SignUpResponseDto.builder()
                .nickname(member.getNickname())
                .build();
    }

    public SignUpResponseVo toVo() {

        return SignUpResponseVo.builder()
                .nickname(nickname)
                .build();
    }
}