package com.team114.starbucks.domain.coupon.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponStatus {

    COUPON_BEFORE_ISSUE("발행 예정"),
    COUPON_ISSUED("발행 완료")
    ;

    private final String couponStatus;

    @JsonValue
    public String getCouponStatus() { return couponStatus; }

    @JsonCreator
    public static CouponStatus getCouponStatus(String value) {
        for (CouponStatus couponStatus : CouponStatus.values()) {
            if (couponStatus.couponStatus.equalsIgnoreCase(value)) {
                return couponStatus;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }
}
