package com.team114.starbucks.domain.cart.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.cart.application.CartService;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.CartUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.in.CartUuidReqVo;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

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

    private final CartService cartService;

    /**
     * 1. 장바구니 항목 생성
     * @param memberUuid
     * @param addCartItemReqVo
     * @return
     */
    @PostMapping
    public BaseResponseEntity<Void> addCartItem(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody AddCartItemReqVo addCartItemReqVo
    ) {
        cartService.addCartItem(AddCartItemReqDto.of(memberUuid, addCartItemReqVo));
        return new BaseResponseEntity<>("장바구니에 추가되었습니다.");
    }

    /**
     * 2. 장바구니 항목 전체 리스트로 조회
     * @param memberUuid
     * @return List<GetAllCartItemsResVo>
     */
    @GetMapping("/all")
    public BaseResponseEntity<List<GetAllCartItemsResVo>> getAllCartItems(
            @RequestHeader("Member-Uuid") String memberUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니 전체 목록 조회에 성공하였습니다.",
                cartService.findAllCartItems(memberUuid).stream().map(GetAllCartItemsResDto::toVo).toList());
    }

    /**
     * 3. 장바구니 항목 전체 정보 변경
     * @param memberUuid
     * @param updateCartItemReqVo
     * @return
     */
    @PutMapping
    public BaseResponseEntity<Void> updateCartItem(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody UpdateCartItemReqVo updateCartItemReqVo
    ) {
        cartService.updateCartItem(UpdateCartItemReqDto.of(memberUuid, updateCartItemReqVo));
        return new BaseResponseEntity<>("장바구니 항목 정보 전체 변경에 성공하였습니다.");
    }

    /**
     * 4. 장바구니 항목 삭제
     * @param memberUuid
     * @param cartUuidReqVo
     * @return
     */
    @DeleteMapping
    public BaseResponseEntity<Void> deleteCartItem(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody CartUuidReqVo cartUuidReqVo
    ) {
        cartService.deleteCartItem(CartUuidReqDto.of(memberUuid, cartUuidReqVo));
        return new BaseResponseEntity<>("장바구니 항목 삭제에 성공하였습니다.");
    }

    /**
     * 5. 장바구니 항목 단건 조회
     * @param memberUuid
     * @param cartUuidReqVo
     * @return
     */
    @GetMapping
    public BaseResponseEntity<GetCartItemResVo> getCartItem(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody CartUuidReqVo cartUuidReqVo
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 단건 조회에 성공하였습니다.",
                cartService.getCartItem(CartUuidReqDto.of(memberUuid, cartUuidReqVo)).toVo());
    }

    /**
     * 6. 장바구니 항목 체크 여부 조회
     * @param memberUuid
     * @param cartUuidReqVo
     * @return
     */
    @GetMapping("/get-selected")
    public BaseResponseEntity<GetItemSelectResVo> getItemSelect(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody CartUuidReqVo cartUuidReqVo
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 체크 여부 조회에 성공하였습니다.",
                cartService.getItemSelect(CartUuidReqDto.of(memberUuid, cartUuidReqVo)).toVo());
    }

    /**
     * 7. 장바구니에서 장바구니 유형별로 상품 UUID 리스트 조회 (일반/예약)
     * @param memberUuid
     * @param cartType
     * @return
     */
    // cartType : general, reservation
    @GetMapping("/product/{cartType}")
    public BaseResponseEntity<List<GetProductUuidResVo>> getProductUuid(
            @RequestHeader("Member-Uuid") String memberUuid,
            @PathVariable String cartType
    ) {
        return new BaseResponseEntity<>(
                "장바구니에서 장바구니 유형별로 Product UUID 리스트 조회 성공",
                cartService.getProductUuidList(CartTypeReqDto.of(memberUuid, cartType))
                        .stream().map(GetProductUuidResDto::toVo).toList());
    }

    /**
     * 8. 장바구니에서 항목 수량 감소
     * @param memberUuid
     * @param cartUuidReqVo
     * @return
     */
    @PutMapping("/item-decrease")
    public BaseResponseEntity<Void> decreaseCartQuantity(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody CartUuidReqVo cartUuidReqVo
    ) {
        cartService.decreaseCartQuantity(CartUuidReqDto.of(memberUuid, cartUuidReqVo));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 1개 감소");
    }

    /**
     * 9. 장바구니에서 항목 수량 증가
     * @param memberUuid
     * @param cartUuidReqVo
     * @return
     */
    @PutMapping("/item-increase")
    public BaseResponseEntity<Void> increaseCartQuantity(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody CartUuidReqVo cartUuidReqVo
    ) {
        cartService.increaseCartQuantity(CartUuidReqDto.of(memberUuid, cartUuidReqVo));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 1개 증가");
    }

    /**
     * 10. 장바구니 유형 별로 총 항목 갯수를 조회
     * @param memberUuid
     * @param cartType
     * @return
     */
    @GetMapping("/count/{cartType}")
    public BaseResponseEntity<CountTotalCartResVo>  countTotalCart(
            @RequestHeader("Member-Uuid") String memberUuid,
            @PathVariable String cartType
    ) {
        return new BaseResponseEntity<>(
                "장바구니 유형 별로 총 항목 갯수 조회 성공",
                cartService.countTotalCart(CartTypeReqDto.of(memberUuid, cartType)).toVo());
    }
}
