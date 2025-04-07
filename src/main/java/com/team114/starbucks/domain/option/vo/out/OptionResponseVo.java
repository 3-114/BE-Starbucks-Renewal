package com.team114.starbucks.domain.option.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OptionResponseVo {

    private final Integer optionId;
    private final String productUuid;
    private final Long colorId;
    private final String colorName;
    private final Long sizeId;
    private final String sizeName;
    private final Integer stock;
    private final Integer optionPrice;
    private final Integer discountRate;

    @Builder
    public OptionResponseVo(
            Integer optionId,
            String productUuid,
            Long colorId,
            String colorName,
            Long sizeId,
            String sizeName,
            Integer stock,
            Integer optionPrice,
            Integer discountRate
    ) {
        this.optionId = optionId;
        this.productUuid = productUuid;
        this.colorId = colorId;
        this.colorName = colorName;
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }
}