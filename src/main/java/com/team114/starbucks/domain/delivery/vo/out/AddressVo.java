package com.team114.starbucks.domain.delivery.vo.out;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class AddressVo {
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
}