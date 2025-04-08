package com.team114.starbucks.domain.product.dto.out;


import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetProductThumbnailByIdResponseDto {
    private Long productId;
    private String productThumbnailUrl;
    private Integer productThumbnailIndex;

    @Builder
    public GetProductThumbnailByIdResponseDto (
            Long productId,
            String productThumbnailUrl,
            Integer productThumbnailIndex
    ) {
        this.productId = productId;
        this.productThumbnailUrl = productThumbnailUrl;
        this.productThumbnailIndex = productThumbnailIndex;
    }

    // dto <- entity
    public static GetProductThumbnailByIdResponseDto from(
            ProductThumbnail productThumbnail
    ) {
        return GetProductThumbnailByIdResponseDto.builder()
                .productId(productThumbnail.getProduct().getId())
                .productThumbnailUrl(productThumbnail.getThumbnailUrl())
                .productThumbnailIndex(productThumbnail.getThumbnailIndex())
                .build();
    }

}