package com.team114.starbucks.domain.product.vo.out;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductPreviewResponseVo {
    private String productName;
    private Integer productPrice;
    private String productThumbnailUrl;
    private Boolean isThumbnail;

    @Builder
    public GetProductPreviewResponseVo(
            String productName,
            Integer productPrice,
            String productThumbnailUrl,
            Boolean isThumbnail
    ) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productThumbnailUrl = productThumbnailUrl;
        this.isThumbnail = isThumbnail;
    }
}
