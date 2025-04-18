package com.team114.starbucks.domain.product.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUuidResVo {

    private String productUuid;

    @Builder
    public ProductUuidResVo(String productUuid) {
        this.productUuid = productUuid;
    }
}
