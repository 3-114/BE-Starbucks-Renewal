package com.team114.starbucks.domain.cart.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.cart.application.CartService;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.CartUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.ProductUuidReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;
import com.team114.starbucks.domain.cart.dto.out.GetQuantityAndSelectedDto;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.out.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
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
     * 11. productUuid 에 해당하는 장바구니 정보 조회
     */

    private final CartService cartService;

    /**
     * 1. 장바구니 항목 생성
     * @param addCartItemReqVo
     * @param authentication
     * @return
     */
    @Operation(summary = "장바구니 항목 생성", tags = {"cart"})
    @PostMapping
    public BaseResponseEntity<Void> addCartItem(
            @RequestBody AddCartItemReqVo addCartItemReqVo,
            Authentication authentication
    ) {
        cartService.addCartItem(AddCartItemReqDto.of(authentication.getName(), addCartItemReqVo));
        return new BaseResponseEntity<>("장바구니에 추가되었습니다.");
    }

    /**
     * 2. 장바구니 항목 전체 리스트로 조회
     * @param authentication
     * @return
     */
    @Operation(summary = "장바구니 항목 전체 리스트로 조회", tags = {"cart"})
    @GetMapping("/all")
    public BaseResponseEntity<List<GetAllCartItemsResVo>> getAllCartItems(
            Authentication authentication
    ) {
        return new BaseResponseEntity<>(
                "장바구니 전체 목록 조회에 성공하였습니다.",
                cartService.findAllCartItems(authentication.getName()).stream().map(GetAllCartItemsResDto::toVo).toList());
    }

    /**
     * 3. 장바구니 항목 전체 정보 변경
     * @param authentication
     * @param updateCartItemReqVo
     * @return
     */
    @Operation(summary = "장바구니 항목 전체 정보 변경", tags = {"cart"})
    @PutMapping
    public BaseResponseEntity<Void> updateCartItem(
            Authentication authentication,
            @RequestBody UpdateCartItemReqVo updateCartItemReqVo
    ) {
        cartService.updateCartItem(UpdateCartItemReqDto.of(authentication.getName(), updateCartItemReqVo));
        return new BaseResponseEntity<>("장바구니 항목 정보 전체 변경에 성공하였습니다.");
    }

    /**
     * 4. 장바구니 항목 삭제
     * @param authentication
     * @param cartUuid
     * @return
     */
    @Operation(summary = "장바구니 항목 삭제", tags = {"cart"})
    @DeleteMapping("/{cartUuid}")
    public BaseResponseEntity<Void> deleteCartItem(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.deleteCartItem(CartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니 항목 삭제에 성공하였습니다.");
    }

    /**
     * 5. 장바구니 항목 단건 조회
     * @param authentication
     * @param cartUuid
     * @return
     */
    @Operation(summary = "장바구니 항목 단건 조회", tags = {"cart"})
    @GetMapping("/{cartUuid}")
    public BaseResponseEntity<GetCartItemResVo> getCartItem(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 단건 조회에 성공하였습니다.",
                cartService.getCartItem(CartUuidReqDto.of(authentication.getName(), cartUuid)).toVo());
    }

    /**
     * 6. 장바구니 항목 체크 여부 조회
     * @param authentication
     * @param cartUuid
     * @return
     */
    @Operation(summary = "장바구니 항목 체크 여부 조회", tags = {"cart"})
    @GetMapping("/{cartUuid}/get-selected")
    public BaseResponseEntity<GetItemSelectResVo> getItemSelect(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 체크 여부 조회에 성공하였습니다.",
                cartService.getItemSelect(CartUuidReqDto.of(authentication.getName(), cartUuid)).toVo());
    }

    /**
     * 7. 장바구니에서 장바구니 유형별로 상품 UUID 리스트 조회 (일반/예약)
     * @param authentication
     * @param cartType
     * @return
     */
    // cartType : general, reservation
    @Operation(summary = "장바구니에서 장바구니 유형별로 상품 UUID 리스트 조회 (일반/예약)", tags = {"cart"})
    @GetMapping("/product/{cartType}")
    public BaseResponseEntity<List<GetProductUuidResVo>> getProductUuid(
            Authentication authentication,
            @PathVariable String cartType
    ) {
        return new BaseResponseEntity<>(
                "장바구니에서 장바구니 유형별로 Product UUID 리스트 조회 성공",
                cartService.getProductUuidList(CartTypeReqDto.of(authentication.getName(), cartType))
                        .stream().map(GetProductUuidResDto::toVo).toList());
    }

    /**
     * 8. 장바구니에서 항목 수량 감소
     * @param authentication
     * @param cartUuid
     * @return
     */
    @Operation(summary = "장바구니에서 항목 수량 감소", tags = {"cart"})
    @PutMapping("/{cartUuid}/item-decrease")
    public BaseResponseEntity<Void> decreaseCartQuantity(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.decreaseCartQuantity(CartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 1개 감소");
    }

    /**
     * 9. 장바구니에서 항목 수량 증가
     * @param authentication
     * @param cartUuid
     * @return
     */
    @Operation(summary = "장바구니에서 항목 수량 증가", tags = {"cart"})
    @PutMapping("/{cartUuid}/item-increase")
    public BaseResponseEntity<Void> increaseCartQuantity(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.increaseCartQuantity(CartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 1개 증가");
    }

    /**
     * 10. 장바구니 유형 별로 총 항목 갯수를 조회
     * @param authentication
     * @param cartType
     * @return
     */
    @Operation(summary = "장바구니 유형 별로 총 항목 갯수를 조회", tags = {"cart"})
    @GetMapping("/count/{cartType}")
    public BaseResponseEntity<CountTotalCartResVo>  countTotalCart(
            Authentication authentication,
            @PathVariable String cartType
    ) {
        return new BaseResponseEntity<>(
                "장바구니 유형 별로 총 항목 갯수 조회 성공",
                cartService.countTotalCart(CartTypeReqDto.of(authentication.getName(), cartType)).toVo());
    }

    @Operation(summary = "ProductUuid 로 cart 조회", tags = {"cart"})
    @GetMapping("/by-product/{productUuid}")
    public List<GetQuantityAndSelectedVo> getCartByProductUuid(
            Authentication authentication,
            @PathVariable String productUuid
    ) {
        return cartService.getCartByProductUuid(
                ProductUuidReqDto.of(authentication.getName(), productUuid)
        ).stream().map(GetQuantityAndSelectedDto::toVo).toList();
    }
}
