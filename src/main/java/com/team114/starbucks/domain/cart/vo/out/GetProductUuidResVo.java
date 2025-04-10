package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetProductUuidResVo {

    private String productUuid;

    @Builder
    public GetProductUuidResVo(String productUuid) {
        this.productUuid = productUuid;
    }
}
