package com.team114.starbucks.domain.delivery.vo.out;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class PhoneNumberVo {
    private final String phoneNumber1;
    private final String phoneNumber2;
}