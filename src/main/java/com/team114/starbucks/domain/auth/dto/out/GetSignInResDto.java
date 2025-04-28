package com.team114.starbucks.domain.auth.dto.out;

import com.team114.starbucks.domain.auth.vo.out.GetSignInResVo;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.enums.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetSignInResDto {

    private String nickname;
    private UserRole userRole;
    private String accessToken;

    @Builder
    public GetSignInResDto(String nickname, UserRole userRole, String accessToken) {
        this.nickname = nickname;
        this.userRole = userRole;
        this.accessToken = accessToken;
    }


    public static GetSignInResDto from(Member member, String accessToken) {
        return GetSignInResDto.builder()
                .accessToken(accessToken)
                .nickname(member.getNickname())
                .userRole(member.getUserRole())
                .build();
    }

    public GetSignInResVo toVo() {
        return GetSignInResVo.builder()
                .accessToken(accessToken)
                .nickname(nickname)
                .userRole(userRole)
                .build();

    }
}
