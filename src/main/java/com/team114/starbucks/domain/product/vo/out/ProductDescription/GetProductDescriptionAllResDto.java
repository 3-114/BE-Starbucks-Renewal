package com.team114.starbucks.domain.product.vo.out.ProductDescription;


import lombok.Builder;
import lombok.Getter;

@Getter
public class GetProductDescriptionAllResDto {

    private String productUuid;
    private String productDescription;

    @Builder
    public GetProductDescriptionAllResDto(String productUuid, String productDescription) {
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

}
