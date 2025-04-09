package com.team114.starbucks.domain.cart.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.cart.application.CartService;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.out.GetAllCartItemsResVo;
import com.team114.starbucks.domain.cart.vo.out.GetCartItemResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    /**
     * /api/v1/cart
     * 1. 장바구니 항목 추가
     * 2. 장바구니 항목 전체 조회
     * 3. 장바구니 항목 정보 변경
     * 4. 장바구니 항목 삭제
     * 5. 장바구니 항목 단건 조회
     * 6. 장바구니 항목 체크 여부 조회
     */

    /**
     * 1. 장바구니 항목 추가
     * @param memberUuid
     * @param productUuid
     * @param addCartItemReqVo
     * @return
     */
    @PostMapping
    public BaseResponseEntity<Void> addCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @RequestHeader("X-Product-UUID") String productUuid,          // product UUID
            @RequestParam(value = "optionId") Long optionId,              // option ID
            @RequestBody AddCartItemReqVo addCartItemReqVo                // 수량, 선택 여부
    ) {
        cartService.addCartItem(
                memberUuid,
                productUuid,
                optionId,
                AddCartItemReqDto.from(addCartItemReqVo)
        );
        return new BaseResponseEntity<>("장바구니에 추가되었습니다.", null);
    }

    /**
     * 2. 장바구니 항목 전체 조회
     * @param memberUuid
     * @return
     */
    @GetMapping
    public BaseResponseEntity<List<GetAllCartItemsResVo>> getAllCartItems(
            @RequestHeader("X-Member-UUID") String memberUuid            // member UUID
    ) {
        List<GetAllCartItemsResVo> result = cartService.findAllCartItems(memberUuid)
                .stream().map(GetAllCartItemsResDto::toVo).toList();
        return new BaseResponseEntity<>("장바구니 전체 목록 조회에 성공하였습니다.", result);
    }

    /**
     * 3. 장바구니 항목 정보 변경
     * @param memberUuid
     * @param cartId
     * @param updateCartItemReqVo
     * @return
     */
    @PutMapping("/{cartId}")
    public BaseResponseEntity<Void> updateCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PathVariable Long cartId,
            @RequestBody UpdateCartItemReqVo updateCartItemReqVo          // 수량, 선택 여부
    ) {
        cartService.updateCartItem(memberUuid, cartId, UpdateCartItemReqDto.from(updateCartItemReqVo));
        return new BaseResponseEntity<>("장바구니 항목 정보 변경에 성공하였습니다.", null);
    }

    /**
     * 4. 장바구니 항목 삭제
     */
    @DeleteMapping("/{cartId}")
    public BaseResponseEntity<Void> deleteCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PathVariable Long cartId
    ) {
        cartService.deleteCartItem(memberUuid, cartId);
        return new BaseResponseEntity<>("장바구니 항목 삭제에 성공하였습니다.", null);
    }

    /**
     * 5. 장바구니 항목 여부 조회
     * @param memberUuid
     * @param cartId
     * @return
     */
    @GetMapping("/{cartId}")
    public BaseResponseEntity<GetCartItemResVo> getCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PathVariable Long cartId
    ) {
        GetCartItemResVo result = cartService.getCartItem(memberUuid, cartId).toVo();
        return new BaseResponseEntity<>("장바구니 항목 단건 조회에 성공하였습니다.", result);
    }

    
}
