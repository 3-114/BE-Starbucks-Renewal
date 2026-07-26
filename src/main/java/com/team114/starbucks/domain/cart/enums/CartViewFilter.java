package com.team114.starbucks.domain.cart.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CartViewFilter {

    MY_CART_ALL("전체"),
    MY_CART_AVAILABLE("구매 가능한 상품 보기"),
    MY_CART_NOT_AVAILABLE("구매 불가능한 상품 보기")
    ;

    private final String cartViewFilter;

    @JsonValue
    public String getCartViewFilter() { return cartViewFilter; }

    @JsonCreator
    public static CartViewFilter fromString(String cartViewFilter) {
        for(CartViewFilter cartViewFilterEnum : CartViewFilter.values()) {
            if(cartViewFilterEnum.getCartViewFilter().equals(cartViewFilter)) {
                return cartViewFilterEnum;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }

}