package com.team114.starbucks.domain.productcategory.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllProductUuidResVo {

    private String productUuid;

    @Builder
    public GetAllProductUuidResVo(String productUuid) {
        this.productUuid = productUuid;
    }
}
