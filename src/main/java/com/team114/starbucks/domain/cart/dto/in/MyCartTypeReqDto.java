package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.enums.CartType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyCartTypeReqDto {

    private String memberUuid;
    private String cartType;

    @Builder
    public MyCartTypeReqDto(String memberUuid, String cartType) {
        this.memberUuid = memberUuid;
        this.cartType = cartType;
    }

    public static MyCartTypeReqDto of(String memberUuid, String cartType) {
        return MyCartTypeReqDto.builder()
                .memberUuid(memberUuid)
                .cartType(cartType)
                .build();
    }
}
