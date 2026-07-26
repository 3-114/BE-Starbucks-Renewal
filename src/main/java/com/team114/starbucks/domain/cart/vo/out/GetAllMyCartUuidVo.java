package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllMyCartUuidVo {

    private String cartUuid;

    @Builder
    public GetAllMyCartUuidVo(String cartUuid) {
        this.cartUuid = cartUuid;
    }

}