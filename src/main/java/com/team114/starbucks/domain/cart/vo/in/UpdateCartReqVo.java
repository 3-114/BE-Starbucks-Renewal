package com.team114.starbucks.domain.cart.vo.in;

import lombok.Getter;

@Getter
public class UpdateCartReqVo {

    private String cartUuid;
    private Long quantity;
    private Boolean selected;
    private Boolean valid;

}