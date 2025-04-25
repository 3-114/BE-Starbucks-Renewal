package com.team114.starbucks.domain.product.dto.out.ProductDescription;

import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.vo.out.ProductDescription.GetProductDescriptionByProductUuidResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductDescriptionByProductUuidResDto {
    private String productUuid;
    private String productDescription;

    @Builder
    public GetProductDescriptionByProductUuidResDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

    public static GetProductDescriptionByProductUuidResDto from(ProductDescription productDescription) {
        return GetProductDescriptionByProductUuidResDto.builder()
                .productUuid(productDescription.getProductUuid())
                .productDescription(productDescription.getProductDescription())
                .build();
    }

    public GetProductDescriptionByProductUuidResVo toVo() {
        return GetProductDescriptionByProductUuidResVo.builder()
                .productUuid(this.productUuid)
                .productDescription(this.productDescription)
                .build();
    }

}