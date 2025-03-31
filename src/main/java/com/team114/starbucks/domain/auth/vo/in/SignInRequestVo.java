package com.team114.starbucks.domain.auth.vo.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignInRequestVo {

    @Email(message = "올바른 이메일 형식으로 입력해주세요.")
    @NotBlank(message = "아이디 또는 패스워드를 다시 확인하세요.")
    private String email;

    @NotBlank(message = "아이디 또는 패스워드를 다시 확인하세요.")
    private String password;

}
