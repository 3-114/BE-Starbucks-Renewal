package com.team114.starbucks.domain.product.vo.out;


import com.team114.starbucks.domain.product.dto.out.CreateProductThumbnailResponseDto;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateProductResponseVo {


    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;
    private String productUuid;


    @Builder
    public CreateProductResponseVo(
            String productUuid, String productName, String brand, Integer productPrice, String productDescription, Integer shippingFee, ProductStatus productStatus
            ) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }
}
