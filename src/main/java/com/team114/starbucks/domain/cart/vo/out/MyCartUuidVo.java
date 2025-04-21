package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyCartUuidVo {

    private String cartUuid;

    @Builder
    public MyCartUuidVo(String cartUuid) {
        this.cartUuid = cartUuid;
    }
}
