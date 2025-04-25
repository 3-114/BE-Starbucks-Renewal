package com.team114.starbucks.domain.option.vo.in;

import lombok.Getter;

@Getter
public class CreateOptionReqVo {

    private String productUuid;
    private Long colorId;
    private Long sizeId;
    private Integer stock;
    private Long optionPrice;
    private Integer discountRate;

}
