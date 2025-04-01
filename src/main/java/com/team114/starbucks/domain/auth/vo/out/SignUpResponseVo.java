package com.team114.starbucks.domain.auth.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpResponseVo {

    private String nickname;

    @Builder
    public SignUpResponseVo(String nickname) {
        this.nickname = nickname;
    }
}
