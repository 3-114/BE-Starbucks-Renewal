package com.team114.starbucks.domain.product.vo.in;

import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateProductReqVo {

    private String productUuid;
    private String brand;
    private String productName;
    private Integer productPrice;
    private ProductStatus productStatus;
    private Integer shippingFee;

    private List<UpdateProductThumbnailReqVo> productThumbnailList;

}
