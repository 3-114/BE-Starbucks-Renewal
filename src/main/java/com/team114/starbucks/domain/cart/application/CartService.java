package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;

public interface CartService {

    /**
     * 1. 장바구니 항목 생성
     * @param memberUuid
     * @param productUuid
     * @param addCartItemReqDto
     * @return
     */
    Void addCartItem(String memberUuid, String productUuid, Long optionId, AddCartItemReqDto addCartItemReqDto);
}
