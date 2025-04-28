package com.team114.starbucks.domain.product.dto.in.ProductDescription;


import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.CreateProductDescriptionReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductDescriptionReqDto {

    private String productUuid;
    private String productDescription;

    @Builder
    public CreateProductDescriptionReqDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

    public static CreateProductDescriptionReqDto from(CreateProductDescriptionReqVo vo) {
        return CreateProductDescriptionReqDto.builder()
                .productUuid(vo.getProductUuid())
                .productDescription(vo.getProductDescription())
                .build();
    }

    public ProductDescription toEntity(String productUuid) {
        return ProductDescription.builder()
                .productUuid(productUuid)
                .productDescription(this.productDescription)
                .build();
    }

}