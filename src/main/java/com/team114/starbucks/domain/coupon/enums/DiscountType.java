package com.team114.starbucks.domain.coupon.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DiscountType {

    DISCOUNT_TYPE_PRICE("정액 할인"),       // 남성
    DISCOUNT_TYPE_PERCENT("정률 할인")      // 여성
    ;

    private final String discountType;

    @JsonValue
    public String getDiscountType() {
        return discountType;
    }

    @JsonCreator
    public static DiscountType getDiscountType(String value) {
        for (DiscountType discountType : DiscountType.values()) {
            if (discountType.getDiscountType().equals(value)) {
                return discountType;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }
}
