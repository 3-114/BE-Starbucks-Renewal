package com.team114.starbucks.domain.product.vo.out;

import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProductResponseVo {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String description;
    private Integer shippingFee;
    private ProductStatus productStatus;

    @Builder
    public UpdateProductResponseVo(
            String productUuid, String productName, String brand, Integer productPrice, String description, Integer shippingFee, ProductStatus productStatus) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.description = description;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }

}
