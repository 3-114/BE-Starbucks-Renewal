package com.team114.starbucks.domain.auth.dto.in;

import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.enums.Gender;
import com.team114.starbucks.domain.auth.vo.in.SignUpRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Getter
public class SignUpRequestDto {

    private String email;
    private String name;
    private String nickname;
    private String password;
    private Date birthday;
    private String phoneNumber;
    private Gender gender;

    @Builder
    public SignUpRequestDto(
            String email,
            String name,
            String nickname,
            String password,
            Date birthday,
            String phoneNumber,
            Gender gender
    ) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static SignUpRequestDto from(
            SignUpRequestVo signUpRequestVo
    ) {
        return SignUpRequestDto.builder()
                .email(signUpRequestVo.getEmail())
                .name(signUpRequestVo.getName())
                .nickname(signUpRequestVo.getNickname())
                .password(signUpRequestVo.getPassword())
                .birthday(signUpRequestVo.getBirthday())
                .phoneNumber(signUpRequestVo.getPhoneNumber())
                .gender(signUpRequestVo.getGender())
                .build();
    }

    public Member toEntity() {

        return Member.builder()
                .email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .birthday(birthday)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .build();
    }
}
