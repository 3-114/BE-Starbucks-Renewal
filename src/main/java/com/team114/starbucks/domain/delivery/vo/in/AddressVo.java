package com.team114.starbucks.domain.delivery.vo.in;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class AddressVo {

    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;

    public AddressVo(String zoneCode, String mainAddress, String detailAddress) {
        if (zoneCode == null || !zoneCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("우편번호는 5자리 숫자여야 합니다.");
        }

        if (mainAddress == null || mainAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("기본 주소는 필수 항목입니다.");
        }

        if (detailAddress == null || detailAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("상세 주소는 필수 항목입니다.");
        }

        this.zoneCode = zoneCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
    }
}