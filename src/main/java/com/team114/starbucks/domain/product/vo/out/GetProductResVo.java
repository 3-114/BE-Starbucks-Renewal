package com.team114.starbucks.domain.product.vo.out;

import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductResVo {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer shippingFee;
    private ProductStatus productStatus;

    @Builder
    public GetProductResVo(
            String productUuid, String productName, String brand, Integer productPrice, Integer shippingFee, ProductStatus productStatus) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
    }

}