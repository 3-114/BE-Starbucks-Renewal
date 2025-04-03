package com.team114.starbucks.domain.product.vo.in;

import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Getter;

@Getter
public class ProductPostReqVo {

    private Long id;
    private String uuid;
    private Brand brand;
    private String name;
    private Integer price;
    private String description;
    private ProductStatus productStatus;
    private Boolean optionFlag; //?
    private Integer shippingFee;


}
