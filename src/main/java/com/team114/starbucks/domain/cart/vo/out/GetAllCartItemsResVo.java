package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllCartItemsResVo {

    private String productName;
    private Integer productPrice;
    private String color;
    private String size;
    private Long optionPrice;
    private Integer discountRate;
    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public GetAllCartItemsResVo(
            String productName,
            Integer productPrice,
            String color,
            String size,
            Long optionPrice,
            Integer discountRate,
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.color = color;
        this.size = size;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }
}
