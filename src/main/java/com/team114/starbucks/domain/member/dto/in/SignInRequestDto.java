package com.team114.starbucks.domain.member.dto.in;

import com.team114.starbucks.domain.member.vo.in.SignInRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignInRequestDto {

    private String email;
    private String password;

    @Builder
    public SignInRequestDto(
            String email,
            String password
    ) {
        this.email = email;
        this.password = password;
    }

    public static SignInRequestDto from(
            SignInRequestVo signInRequestVo
    ) {
        return SignInRequestDto.builder()
                .email(signInRequestVo.getEmail())
                .password(signInRequestVo.getPassword())
                .build();
    }
}
