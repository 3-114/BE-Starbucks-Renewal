package com.team114.starbucks.domain.cart.application;

import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.CartUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.ProductUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.*;
import com.team114.starbucks.domain.cart.vo.out.CartTypeReqDto;
import com.team114.starbucks.domain.cart.vo.out.CountTotalCartResVo;
import com.team114.starbucks.domain.cart.vo.out.GetQuantityAndSelectedVo;
import com.team114.starbucks.domain.cart.vo.out.MyCartUuidVo;

import java.util.List;

public interface CartService {

    /**
     * /api/v1/cart
     * 1. 장바구니 항목 생성
     * 2. 장바구니 항목 전체 리스트로 조회
     * 3. 장바구니 항목 전체 정보 변경
     * 4. 장바구니 항목 삭제
     * 5. 장바구니 항목 단건 조회
     * 6. 장바구니 항목 체크 여부 조회
     * 7. 장바구니에서 장바구니 유형별로 상품 UUID 리스트 조회 (일반/예약)
     * 8. 장바구니에서 항목 수량 감소
     * 9. 장바구니에서 항목 수량 증가
     * 10. 장바구니 유형 별로 총 항목 갯수를 조회
     */

    void addCartItem(AddCartItemReqDto addCartItemReqDto);

    List<GetAllCartItemsResDto> findAllCartItems(String memberUuid);

    void updateCartItem(UpdateCartItemReqDto updateCartItemReqDto);

    void deleteCartItem(CartUuidReqDto cartUuidReqDto);

    CartAndProductResDto getCartItem(CartUuidReqDto cartUuidReqDto);

    GetItemSelectResDto getItemSelect(CartUuidReqDto cartUuidReqDto);

    List<GetProductUuidResDto> getProductUuidList(CartTypeReqDto cartTypeReqDto);

    void decreaseCartQuantity(CartUuidReqDto cartUuidReqDto);

    void increaseCartQuantity(CartUuidReqDto cartUuidReqDto);

    CountTotalCartResDto countTotalCart(CartTypeReqDto cartTypeReqDto);

    List<GetQuantityAndSelectedDto> getCartByProductUuid(ProductUuidReqDto productUuidReqDto);

    List<MyCartUuidDto> getMyCartUuids(String memberUuid);

    void toggleCartSelection(CartUuidReqDto cartUuidReqDto);
}
