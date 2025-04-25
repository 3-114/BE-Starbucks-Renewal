package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMyCartTypeReqDto {

    private String memberUuid;
    private String cartType;

    @Builder
    public GetMyCartTypeReqDto(String memberUuid, String cartType) {
        this.memberUuid = memberUuid;
        this.cartType = cartType;
    }

    public static GetMyCartTypeReqDto of(String memberUuid, String cartType) {
        return GetMyCartTypeReqDto.builder()
                .memberUuid(memberUuid)
                .cartType(cartType)
                .build();
    }

}