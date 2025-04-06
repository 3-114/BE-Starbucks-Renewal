package com.team114.starbucks.domain.memberCoupon.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponViewFilter {

    MY_COUPON_ALL("전체"),
    MY_COUPON_AVAILABLE("사용 가능"),
    MY_COUPON_USED("사용 완료"),
    MY_COUPON_EXPIRED("기간 만료"),
    MY_COUPON_NOT_AVAILABLE("사용 불가")       // 사용 완료 + 기간 만료
    ;

    private final String couponViewFilter;

    @JsonValue
    public String getCouponViewFilter() { return couponViewFilter; }

    @JsonCreator
    public static CouponViewFilter fromString(String couponViewFilter) {
        for (CouponViewFilter couponViewFilterEnum : CouponViewFilter.values()) {
            if (couponViewFilterEnum.getCouponViewFilter().equals(couponViewFilter)) {
                return couponViewFilterEnum;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }
}
