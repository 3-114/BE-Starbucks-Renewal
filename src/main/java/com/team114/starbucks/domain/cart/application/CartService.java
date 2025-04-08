package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;

import java.util.List;

public interface CartService {

    /**
     * /api/v1/cart
     * 1. 장바구니 항목 추가
     * 2. 장바구니 항목 전체 조회
     * 3. 장바구니 항목 수량 추가
     * 4. 장바구니 항목 수량 감소
     * 5. 장바구니 항목 삭제
     */

    /**
     * 1. 장바구니 항목 생성
     * @param memberUuid
     * @param productUuid
     * @param addCartItemReqDto
     * @return
     */
    Void addCartItem(String memberUuid, String productUuid, Long optionId, AddCartItemReqDto addCartItemReqDto);

    /**
     * 2. 장바구니 항목 전체 조회
     * @param memberUuid
     * @return
     */
    List<GetAllCartItemsResDto> findAllCartItems(String memberUuid);
}
