package com.team114.starbucks.domain.product.vo.in.ProductDescription;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateProductDescriptionReqVo {

    private String productUuid;
    private String productDescription;

}
