package com.team114.starbucks.domain.product.vo.in;

import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Getter;

@Getter
public class GetProductReqVo {

    private String productUuid;
    private String brand;
    private String productName;
    private Integer productPrice;
    private String description;
    private ProductStatus productStatus;
    private Integer shippingFee;

}
