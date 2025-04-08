package com.team114.starbucks.domain.auth.vo.in;

import com.team114.starbucks.domain.member.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.util.Date;

@Getter
public class SignUpRequestVo {

    /**
     * @NotNull : null 불가, 빈 문자열 허용, 공백 문자열 허용
     * @NotEmpty : null 불가, 빈 문자열 불가, 공백 문자열 허용
     * @NotBlank : null 불가, 빈 문자열 불가, 공백 문자열 불가
     * @Email : 이메일 형식 이어야 함.
     * @Min : 숫자 형식에만 사용 가능
     * @Max : 숫자 형식에만 사용 가능
     * @Size : 문자열 길이 제한
     * @Pattern : 패턴 지정
     */

    @Email(message = "올바른 이메일 형식으로 입력해주세요.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, message = "이름은 2글자 이상으로 입력해주세요.")
    @Size(max = 8, message = "이름은 8글자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, message = "닉네임은 2글자 이상으로 입력해주세요.")
    @Size(max = 8, message = "닉네임은 8글자 이하로 입력해주세요.")
    private String nickname;

    @Size(min = 8, message = "비밀번호는 최소 8글자 이상으로 입력해주세요.")
    @Pattern(
            // regexp : regular expression
            // !@#$%^&*()_+\-={}\[\]:;"'|<>,.?/~
            // !@#$%^&*
            // 소문자도 필수로 추가하고 싶으면, (?=.*[a-z]) 추가
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).*$",
            message = "대문자를 포함한 영문,숫자,특수문자를 최소 1글자 이상 포함하여 작성해주세요.)"
    )
    @NotBlank(message = "패스워드을 입력해주세요.")
    private String password;

    // 생년월일은 과거여야 함. (현재 및 미래 불가)
    @Past(message = "생년월일을 다시 확인해주세요.")
    @NotBlank(message = "생년월일을 입력해주세요.")
    private Date birthday;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(
            regexp = "^010-\\d{4}-\\d{4}$",
            message = "올바른 휴대폰 번호 형식으로 입력해주세요. (010-****-****)"
    )
    private String phoneNumber;

    @NotBlank(message = "성별을 올바르게 입력해주세요. (남성 또는 여성)")
    private Gender gender;

//    private List<AgreementVo> agreeVo;

}
