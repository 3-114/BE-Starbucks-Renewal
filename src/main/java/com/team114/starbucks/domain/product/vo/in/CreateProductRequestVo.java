package com.team114.starbucks.domain.product.vo.in;


import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateProductRequestVo {


    private String brand;
    private String productName;
    private Integer productPrice;
    private String description;
    private ProductStatus productStatus;
    private Integer shippingFee;

    private List<CreateProductThumbnailRequestVo> thumbnailList;

    @Builder
    public CreateProductRequestVo(
            String brand,
            String productName,
            Integer productPrice,
            String description,
            ProductStatus productStatus,
            Integer shippingFee,
            List<CreateProductThumbnailRequestVo> thumbnailList
    ) {
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.productStatus = productStatus;
        this.shippingFee = shippingFee;
        this.thumbnailList = thumbnailList;
    }


}
