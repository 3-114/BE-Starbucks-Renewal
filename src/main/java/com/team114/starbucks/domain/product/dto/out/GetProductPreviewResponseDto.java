package com.team114.starbucks.domain.product.dto.out;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.vo.out.GetProductPreviewResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductPreviewResponseDto {

    private String productName;
    private Integer productPrice;
    private String productThumbnailUrl;
    private Boolean isThumbnail;

    @Builder
    public GetProductPreviewResponseDto(
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



    public static GetProductPreviewResponseDto from(Product product, ProductThumbnail productThumbnail) {
        return GetProductPreviewResponseDto.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productThumbnailUrl(productThumbnail.getThumbnailUrl())
                .isThumbnail(productThumbnail.getIsThumbnail())
                .build();
    }

    public GetProductPreviewResponseVo toVo(){
        return GetProductPreviewResponseVo.builder()
                .productName(productName)
                .productPrice(productPrice)
                .productThumbnailUrl(productThumbnailUrl)
                .isThumbnail(isThumbnail)
                .build();
    }


}
