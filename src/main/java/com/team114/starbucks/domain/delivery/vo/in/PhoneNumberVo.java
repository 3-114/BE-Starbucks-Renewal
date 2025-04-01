package com.team114.starbucks.domain.delivery.vo.in;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class PhoneNumberVo {

    private final String phoneNumber1;
    private final String phoneNumber2;

    public PhoneNumberVo(String phoneNumber1, String phoneNumber2) {
        if (phoneNumber1 == null || !phoneNumber1.matches("\\d{11}")) {
            throw new IllegalArgumentException("전화번호1은 11자리 숫자여야 합니다.");
        }

        if (phoneNumber2 != null && !phoneNumber2.matches("\\d{11}")) {
            throw new IllegalArgumentException("전화번호2는 11자리 숫자여야 합니다.");
        }

        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
    }
}