package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartTypeReqDto {

    private String memberUuid;
    private String cartType;

    @Builder
    public CartTypeReqDto(String memberUuid, String cartType) {
        this.memberUuid = memberUuid;
        this.cartType = cartType;
    }

    public static CartTypeReqDto of(String memberUuid, String cartType) {
        return CartTypeReqDto.builder()
                .memberUuid(memberUuid)
                .cartType(cartType)
                .build();
    }
}
