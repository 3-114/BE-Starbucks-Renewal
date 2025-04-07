package com.team114.starbucks.domain.coupon.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAllCouponsResVo {

    private String couponUuid;
    private String name;

    @Builder
    public GetAllCouponsResVo(
            String couponUuid,
            String name
    ) {
        this.couponUuid = couponUuid;
        this.name = name;
    }
}
