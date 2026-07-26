package com.team114.starbucks.domain.cart.vo.in;

import lombok.Getter;

@Getter
public class CreateCartReqVo {

    private String productUuid;
    private Long quantity;

}