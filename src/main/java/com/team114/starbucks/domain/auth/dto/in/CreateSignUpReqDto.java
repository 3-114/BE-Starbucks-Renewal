package com.team114.starbucks.domain.auth.dto.in;

import com.team114.starbucks.domain.auth.vo.in.CreateSignUpReqVo;
import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.member.enums.Gender;
import com.team114.starbucks.domain.member.enums.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateSignUpReqDto {

    private String email;
    private String name;
    private String nickname;
    private String password;
    private Date birthday;
    private String phoneNumber;
    private Gender gender;

    @Builder
    public CreateSignUpReqDto(
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

    public static CreateSignUpReqDto from(
            CreateSignUpReqVo createSignUpReqVo
    ) {
        return CreateSignUpReqDto.builder()
                .email(createSignUpReqVo.getEmail())
                .name(createSignUpReqVo.getName())
                .nickname(createSignUpReqVo.getNickname())
                .password(createSignUpReqVo.getPassword())
                .birthday(createSignUpReqVo.getBirthday())
                .phoneNumber(createSignUpReqVo.getPhoneNumber())
                .gender(createSignUpReqVo.getGender())
                .build();
    }

    public Member toEntity(String password) {

        return Member.builder()
                .memberUuid(UUID.randomUUID().toString())
                .email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .birthday(birthday)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .userRole(UserRole.ROLE_USER)
                .build();
    }
}
