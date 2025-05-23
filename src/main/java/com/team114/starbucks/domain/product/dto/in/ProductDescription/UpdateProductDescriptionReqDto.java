package com.team114.starbucks.domain.product.dto.in.ProductDescription;


import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.UpdateProductDescriptionReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateProductDescriptionReqDto {

    private String productUuid;
    private String productDescription;

    @Builder
    public UpdateProductDescriptionReqDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

    public static UpdateProductDescriptionReqDto from(UpdateProductDescriptionReqVo vo) {
        return UpdateProductDescriptionReqDto.builder()
                .productUuid(vo.getProductUuid())
                .productDescription(vo.getProductDescription())
                .build();
    }

    public ProductDescription toEntity(ProductDescription productDescription) {
        return ProductDescription.builder()
                .id(productDescription.getId())
                .productUuid(this.productUuid) // productDescription.getProductUuid()?
                .productDescription(this.productDescription)
                .build();
    }

}