package com.team114.starbucks.domain.product.dto.out.ProductDescription;


import com.team114.starbucks.domain.product.entity.ProductDescription;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllProductDescriptionResDto {

    private String productUuid;
    private String productDescription;

    @Builder
    public GetAllProductDescriptionResDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

    public static GetAllProductDescriptionResDto from(ProductDescription productDescription) {
        return GetAllProductDescriptionResDto.builder()
                .productUuid(productDescription.getProductUuid())
                .productDescription(productDescription.getProductDescription())
                .build();
    }

    public com.team114.starbucks.domain.product.vo.out.ProductDescription.GetAllProductDescriptionResDto toVo() {
        return com.team114.starbucks.domain.product.vo.out.ProductDescription.GetAllProductDescriptionResDto.builder()
                .productUuid(this.productUuid)
                .productDescription(this.productDescription)
                .build();
    }

}