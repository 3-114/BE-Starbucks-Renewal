package com.team114.starbucks.domain.option.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OptionResponseVo {

    private final Long optionId;
    private final String productUuid;
    private final Long colorId;
    private final Long sizeId;
    private final Integer stock;
    private final Long optionPrice;
    private final Integer discountRate;

    @Builder
    public OptionResponseVo(
            Long optionId,
            String productUuid,
            Long colorId,
            Long sizeId,
            Integer stock,
            Long optionPrice,
            Integer discountRate
    ) {
        this.optionId = optionId;
        this.productUuid = productUuid;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }
}