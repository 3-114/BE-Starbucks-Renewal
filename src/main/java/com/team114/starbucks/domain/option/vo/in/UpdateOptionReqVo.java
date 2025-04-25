package com.team114.starbucks.domain.option.vo.in;

import lombok.Getter;

@Getter
public class UpdateOptionReqVo {

    private Long optionId;
    private Integer stock;
    private Long optionPrice;
    private Integer discountRate;

}