package com.team114.starbucks.domain.auth.vo.out;

import com.team114.starbucks.domain.member.enums.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInResponseVo {

    private String nickname;
    private UserRole userRole;
    private String accessToken;

    @Builder
    public SignInResponseVo(String nickname, UserRole userRole, String accessToken) {
        this.nickname = nickname;
        this.userRole = userRole;
        this.accessToken = accessToken;
    }
}
