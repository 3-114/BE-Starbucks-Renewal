package com.team114.starbucks.domain.productcategory.dto.in;

import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import com.team114.starbucks.domain.productcategory.vo.in.CreateProductCategoryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductCategoryReqDto {

    private String productUuid;
    private String mainCategoryUuid;
    private String subCategoryUuid;
    private String eventUuid;

    @Builder
    public CreateProductCategoryReqDto(String productUuid, String mainCategoryUuid, String subCategoryUuid, String eventUuid) {
        this.productUuid = productUuid;
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryUuid = subCategoryUuid;
        this.eventUuid = eventUuid;
    }

    public static CreateProductCategoryReqDto from(CreateProductCategoryReqVo createProductCategoryReqVo) {
        return CreateProductCategoryReqDto.builder()
                .productUuid(createProductCategoryReqVo.getProductUuid())
                .mainCategoryUuid(createProductCategoryReqVo.getMainCategoryUuid())
                .subCategoryUuid(createProductCategoryReqVo.getSubCategoryUuid())
                .eventUuid(createProductCategoryReqVo.getSubCategoryUuid())
                .build();
    }

    public ProductCategory toEntity() {
        return ProductCategory.builder()
                .productUuid(productUuid)
                .mainCategoryUuid(mainCategoryUuid)
                .subCategoryUuid(subCategoryUuid)
                .eventUuid(eventUuid)
                .build();
    }

}
