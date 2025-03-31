package com.team114.starbucks.domain.auth.dto.out;

import com.team114.starbucks.domain.auth.vo.out.SignInResponseVo;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.enums.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInResponseDto {

    private String nickname;
    private UserRole userRole;
    private String accessToken;

    @Builder
    public SignInResponseDto(
            String nickname,
            UserRole userRole,
            String accessToken) {
        this.nickname = nickname;
        this.userRole = userRole;
        this.accessToken = accessToken;
    }


    public static SignInResponseDto from(Member member, String accessToken) {

        return SignInResponseDto.builder()
                .accessToken(accessToken)
                .nickname(member.getNickname())
                .userRole(member.getUserRole())
                .build();
    }

    public SignInResponseVo toVo() {
        return SignInResponseVo.builder()
                .accessToken(accessToken)
                .nickname(nickname)
                .userRole(userRole)
                .build();

    }
}
