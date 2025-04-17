package com.team114.starbucks.domain.productcategory.dto.out;

import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import com.team114.starbucks.domain.productcategory.vo.out.GetAllProductUuidResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllProductUuidResDto {

    private String productUuid;

    @Builder
    public GetAllProductUuidResDto(String productUuid) {
        this.productUuid = productUuid;
    }

    public static GetAllProductUuidResDto from(ProductCategory productCategory) {
        return GetAllProductUuidResDto.builder()
                .productUuid(productCategory.getProductUuid())
                .build();
    }

    public GetAllProductUuidResVo toVo() {
        return GetAllProductUuidResVo.builder()
                .productUuid(productUuid)
                .build();

    }
}
