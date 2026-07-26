package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCartAndProductResVo {

    private Long quantity;
    private Boolean selected;
    private String cartUuid;
    private String productName;
    private Integer productPrice;
    private String productThumbnailUrl;
    private Boolean isThumbnail;
    private Integer shippingFee;

    @Builder
    public GetCartAndProductResVo(
            Long quantity,
            Boolean selected,
            String cartUuid,
            String productName,
            Integer productPrice,
            String productThumbnailUrl,
            Boolean isThumbnail,
            Integer shippingFee
    ) {
        this.quantity = quantity;
        this.selected = selected;
        this.cartUuid = cartUuid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productThumbnailUrl = productThumbnailUrl;
        this.isThumbnail = isThumbnail;
        this.shippingFee = shippingFee;
    }

}