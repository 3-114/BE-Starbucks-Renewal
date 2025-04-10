package com.team114.starbucks.domain.cart.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CartType {

    CART_TYPE_GENERAL("일반"),
    CART_TYPE_RESERVATION("예약")
    ;

    private final String cartType;

    @JsonValue
    public String getCartType() { return cartType; }

    @JsonCreator
    public static CartType fromString(String cartType) {
        for(CartType c : CartType.values()) {
            if(c.getCartType().equals(cartType)) {
                return c;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }
}
