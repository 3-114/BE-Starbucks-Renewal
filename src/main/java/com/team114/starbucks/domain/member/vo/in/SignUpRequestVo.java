package com.team114.starbucks.domain.member.vo.in;

import com.team114.starbucks.domain.member.enums.Gender;
import lombok.Getter;

import java.util.Date;

@Getter
public class SignUpRequestVo {

    private String email;
    private String name;
    private String nickname;
    private String password;
    private Date birthday;
    private String phoneNumber;
    private Gender gender;

}
