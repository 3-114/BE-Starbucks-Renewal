package com.team114.starbucks.domain.product.vo.in;


import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateProductRequestVo {

    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;

    private List<CreateProductThumbnailRequestVo> productThumbnailList;

    @Builder
    public CreateProductRequestVo(
            String brand,
            String productName,
            Integer productPrice,
            String productDescription,
            ProductStatus productStatus,
            Integer shippingFee,
            List<CreateProductThumbnailRequestVo> productThumbnailList
    ) {
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStatus = productStatus;
        this.shippingFee = shippingFee;
        this.productThumbnailList = productThumbnailList;
    }


}
