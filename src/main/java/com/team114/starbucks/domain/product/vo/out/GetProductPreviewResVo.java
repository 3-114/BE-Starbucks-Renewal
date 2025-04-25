package com.team114.starbucks.domain.product.vo.out;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductPreviewResVo {

    private String productName;
    private Integer productPrice;
    private String productThumbnailUrl;
    private Boolean isThumbnail;
    private Integer shippingFee;

    @Builder
    public GetProductPreviewResVo(
            String productName,
            Integer productPrice,
            String productThumbnailUrl,
            Boolean isThumbnail,
            Integer shippingFee
    ) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productThumbnailUrl = productThumbnailUrl;
        this.isThumbnail = isThumbnail;
        this.shippingFee = shippingFee;
    }

}