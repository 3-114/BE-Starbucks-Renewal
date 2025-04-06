package com.team114.starbucks.domain.memberCoupon.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponStatus {

    COUPON_AVAILABLE("사용 가능"),
    COUPON_USED("사용 완료"),
    COUPON_EXPIRED("기간 만료")
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
