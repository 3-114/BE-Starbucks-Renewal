package com.team114.starbucks.domain.product.dto.out;


import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductThumbnailByIdResDto {

    private Long productId;
    private String productThumbnailUrl;
    private Integer productThumbnailIndex;
    private Boolean isThumbnail;

    @Builder
    public GetProductThumbnailByIdResDto(
            Long productId,
            String productThumbnailUrl,
            Integer productThumbnailIndex,
            Boolean isThumbnail
    ) {
        this.productId = productId;
        this.productThumbnailUrl = productThumbnailUrl;
        this.productThumbnailIndex = productThumbnailIndex;
        this.isThumbnail = isThumbnail;
    }

    public static GetProductThumbnailByIdResDto from(ProductThumbnail productThumbnail) {
        return GetProductThumbnailByIdResDto.builder()
                .productId(productThumbnail.getProduct().getId())
                .productThumbnailUrl(productThumbnail.getThumbnailUrl())
                .productThumbnailIndex(productThumbnail.getThumbnailIndex())
                .isThumbnail(productThumbnail.getIsThumbnail())
                .build();
    }

}