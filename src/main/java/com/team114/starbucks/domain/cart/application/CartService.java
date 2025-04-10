package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetCartItemResDto;
import com.team114.starbucks.domain.cart.dto.out.GetItemSelectResDto;

import java.util.List;

public interface CartService {

    /**
     * /api/v1/cart
     * 1. 장바구니 항목 추가
     * 2. 장바구니 항목 전체 조회
     * 3. 장바구니 항목 정보 변경
     * 4. 장바구니 항목 삭제
     * 5. 장바구니 항목 단건 조회
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

    /**
     * 3. 장바구니 항목 정보 변경
     * @param memberUuid
     * @param cartUuid
     * @param updateCartItemReqDto
     * @return
     */
    Void updateCartItem(String memberUuid, String cartUuid, UpdateCartItemReqDto updateCartItemReqDto);

    /**
     * 4. 장바구니 항목 삭제
     * @param memberUuid
     * @param cartUuid
     * @return
     */
    Void deleteCartItem(String memberUuid, String cartUuid);

    /**
     * 5. 장바구니 항목 단건 조회
     * @param memberUuid
     * @param cartUuid
     * @return
     */
    GetCartItemResDto getCartItem(String memberUuid, String cartUuid);

    /**
     * 6. 장바구니 체크여부 조회
     * @param memberUuid
     * @param cartUuid
     * @return
     */
    GetItemSelectResDto getItemSelect(String memberUuid, String cartUuid);
}
