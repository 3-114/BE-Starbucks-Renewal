package com.team114.starbucks.domain.product.dto.in;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.vo.in.CreateProductThumbnailReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductThumbnailReqDto {

    private String thumbnailUrl;
    private Integer thumbnailIndex;
    private Boolean isThumbnail;
    private String uploadedBy;

    @Builder
    public CreateProductThumbnailReqDto(
            String thumbnailUrl,
            Integer thumbnailIndex,
            Boolean isThumbnail,
            String uploadedBy
    ) {
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailIndex = thumbnailIndex;
        this.isThumbnail = isThumbnail;
        this.uploadedBy = uploadedBy;
    }

    public static CreateProductThumbnailReqDto from(CreateProductThumbnailReqVo vo) {
        return CreateProductThumbnailReqDto.builder()
                .thumbnailUrl(vo.getThumbnailUrl())
                .thumbnailIndex(vo.getThumbnailIndex())
                .isThumbnail(vo.getIsThumbnail())
                .uploadedBy(vo.getUploadedBy())
                .build();
    }

    public ProductThumbnail toEntity(Product product) {
        return ProductThumbnail.builder()
                .product(product)
                .thumbnailUrl(thumbnailUrl)
                .thumbnailIndex(thumbnailIndex)
                .isThumbnail(isThumbnail)
                .uploadedBy(uploadedBy)
                .build();
    }

}