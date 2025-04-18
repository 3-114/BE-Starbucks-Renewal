package com.team114.starbucks.domain.product.dto.out;

import com.team114.starbucks.domain.product.vo.out.ProductUuidResVo;
import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUuidResDto {

    private String productUuid;

    @Builder
    public ProductUuidResDto(String productUuid) {
        this.productUuid = productUuid;
    }

    public static ProductUuidResDto from(ProductCategory productCategory) {
        return ProductUuidResDto.builder()
                .productUuid(productCategory.getProductUuid())
                .build();
    }

    public ProductUuidResVo toVo() {
        return ProductUuidResVo.builder()
                .productUuid(productUuid)
                .build();
    }
}
