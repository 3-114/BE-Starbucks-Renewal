package com.team114.starbucks.domain.product.dto.out.ProductDescription;


import com.team114.starbucks.domain.product.entity.ProductDescription;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductDescriptionAllResDto {

    private String productUuid;
    private String productDescription;

    @Builder
    public GetProductDescriptionAllResDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

    public static GetProductDescriptionAllResDto from(ProductDescription productDescription) {
        return com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionAllResDto.builder()
                .productUuid(productDescription.getProductUuid())
                .productDescription(productDescription.getProductDescription())
                .build();
    }

    public com.team114.starbucks.domain.product.vo.out.ProductDescription.GetProductDescriptionAllResDto toVo() {
        return com.team114.starbucks.domain.product.vo.out.ProductDescription.GetProductDescriptionAllResDto.builder()
                .productUuid(this.productUuid)
                .productDescription(this.productDescription)
                .build();
    }



}
