package com.team114.starbucks.domain.product.dto.in;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.vo.in.CreateProductThumbnailRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateProductThumbnailRequestDto {

    private String thumbnailUrl;
    private Integer thumbnailIndex;
    private Boolean isThumbnail;
    private String uploadedBy;

    @Builder
    public CreateProductThumbnailRequestDto(
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

    //vo -> dto
    public static CreateProductThumbnailRequestDto from(
            CreateProductThumbnailRequestVo vo
    ) {
        return CreateProductThumbnailRequestDto.builder()
                .thumbnailUrl(vo.getThumbnailUrl())
                .thumbnailIndex(vo.getThumbnailIndex())
                .isThumbnail(vo.getIsThumbnail())
                .uploadedBy(vo.getUploadedBy())
                .build();
    }

    // dto -> entity
    public ProductThumbnail toEntity(
            Product product
    ) {
        return ProductThumbnail.builder()
                .product(product)
                .thumbnailUrl(thumbnailUrl)
                .thumbnailIndex(thumbnailIndex)
                .isThumbnail(isThumbnail)
                .uploadedBy(uploadedBy)
                .build();
    }


}
