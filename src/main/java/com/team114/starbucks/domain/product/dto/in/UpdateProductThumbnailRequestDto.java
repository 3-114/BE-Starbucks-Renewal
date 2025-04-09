package com.team114.starbucks.domain.product.dto.in;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.vo.in.UpdateProductThumbnailRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProductThumbnailRequestDto {

    private String thumbnailUrl;
    private Integer thumbnailIndex;
    private Boolean isThumbnail;
    private String uploadedBy;


    @Builder
    public UpdateProductThumbnailRequestDto(
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


    public static UpdateProductThumbnailRequestDto from(
            UpdateProductThumbnailRequestVo vo
    ) {
        return UpdateProductThumbnailRequestDto.builder()
                .thumbnailUrl(vo.getThumbnailUrl())
                .thumbnailIndex(vo.getThumbnailIndex())
                .isThumbnail(vo.getIsThumbnail())
                .uploadedBy(vo.getUploadedBy())
                .build();
    }

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
