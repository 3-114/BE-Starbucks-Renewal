package com.team114.starbucks.domain.product.vo.out.ProductDescription;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductDescriptionByProductUuidResVo {

    private String productUuid;
    private String productDescription;

    @Builder
    public GetProductDescriptionByProductUuidResVo(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

}
