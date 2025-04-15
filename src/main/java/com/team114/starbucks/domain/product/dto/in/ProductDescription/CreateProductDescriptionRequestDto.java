package com.team114.starbucks.domain.product.dto.in.ProductDescription;


import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.CreateProductDescriptionRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductDescriptionRequestDto {

    private String productUuid;
    private String productDescription;

    @Builder
    public CreateProductDescriptionRequestDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

    public static CreateProductDescriptionRequestDto from(
            CreateProductDescriptionRequestVo vo
    ) {
        return CreateProductDescriptionRequestDto.builder()
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
