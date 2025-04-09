package com.team114.starbucks.domain.cart.vo.in;

import lombok.Getter;

@Getter
public class UpdateCartItemReqVo {

    private Long quantity;
    private Boolean selected;

}
