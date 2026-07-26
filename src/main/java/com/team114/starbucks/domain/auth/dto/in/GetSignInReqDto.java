package com.team114.starbucks.domain.auth.dto.in;

import com.team114.starbucks.domain.auth.vo.in.GetSignInReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetSignInReqDto {

    private String email;
    private String password;

    @Builder
    public GetSignInReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static GetSignInReqDto from(GetSignInReqVo getSignInReqVo) {
        return GetSignInReqDto.builder()
                .email(getSignInReqVo.getEmail())
                .password(getSignInReqVo.getPassword())
                .build();
    }
}

