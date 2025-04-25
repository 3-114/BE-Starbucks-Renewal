package com.team114.starbucks.domain.cart.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.cart.application.CartService;
import com.team114.starbucks.domain.cart.dto.in.*;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;
import com.team114.starbucks.domain.cart.dto.out.GetQuantityAndSelectedDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllMyCartUuidDto;
import com.team114.starbucks.domain.cart.vo.in.CreateCartReqVo;
import com.team114.starbucks.domain.cart.vo.in.CartQuantityReqVo;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartReqVo;
import com.team114.starbucks.domain.cart.vo.out.*;
import com.team114.starbucks.domain.cart.vo.out.GetMyCartTypeReqDto;
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
     * 11. ProductUuid 로 cart 조회
     * 12. memberUuid 로 cartUuid list 조회
     * 13. 장바구니 항목 체크여부 변경
     * 14. 장바구니 항목 전체 선택 및 전체 해제
     * 15. 장바구니 항목 갯수 정보 변경
     */

    private final CartService cartService;

    /**
     * 1. 장바구니 항목 생성
     *
     * @param createCartReqVo 장바구니 생성 데이터
     * @param authentication   멤버 UUID
     * @return 장바구니 생성 결과
     */
    @Operation(summary = "장바구니 항목 생성", tags = {"cart"})
    @PostMapping
    public BaseResponseEntity<Void> addCartItem(
            @RequestBody CreateCartReqVo createCartReqVo,
            Authentication authentication
    ) {
        cartService.addCartItem(CreateCartReqDto.of(authentication.getName(), createCartReqVo));
        return new BaseResponseEntity<>("장바구니에 추가되었습니다.");
    }

    /**
     * 2. 장바구니 항목 전체 리스트로 조회
     *
     * @param authentication 멤버 UUID
     * @return 장바구니 전체 조회 결과
     */
    @Operation(summary = "장바구니 항목 전체 리스트로 조회", tags = {"cart"}, hidden = true)
    @GetMapping("/all")
    public BaseResponseEntity<List<GetAllCartResVo>> getAllCartItems(
            Authentication authentication
    ) {
        return new BaseResponseEntity<>(
                "장바구니 전체 목록 조회에 성공하였습니다.",
                cartService.findAllCartItems(authentication.getName()).stream().map(GetAllCartResDto::toVo).toList());
    }

    /**
     * 3. 장바구니 항목 전체 정보 변경
     *
     * @param authentication      멤버 UUID
     * @param updateCartReqVo 장바구니 수정 데이터
     * @return 장바구니 수정 결과
     */
    @Operation(summary = "장바구니 항목 전체 정보 변경", tags = {"cart"}, hidden = true)
    @PutMapping
    public BaseResponseEntity<Void> updateCartItem(
            Authentication authentication,
            @RequestBody UpdateCartReqVo updateCartReqVo
    ) {
        cartService.updateCartItem(UpdateCartReqDto.of(authentication.getName(), updateCartReqVo));
        return new BaseResponseEntity<>("장바구니 항목 정보 전체 변경에 성공하였습니다.");
    }

    /**
     * 4. 장바구니 항목 삭제
     *
     * @param authentication 멤버 UUID
     * @param cartUuid       카트 UUID
     * @return 장바구니 삭제 결과
     */
    @Operation(summary = "장바구니 항목 삭제", tags = {"cart"})
    @DeleteMapping("/{cartUuid}")
    public BaseResponseEntity<Void> deleteCartItem(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.deleteCartItem(GetMyCartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니 항목 삭제에 성공하였습니다.");
    }

    /**
     * 5. 장바구니 항목 단건 조회
     *
     * @param authentication 멤버 UUID
     * @param cartUuid       카트 UUID
     * @return 장바구니 단건 조회 결과
     */
    @Operation(summary = "장바구니 항목 단건 조회", tags = {"cart"})
    @GetMapping("/{cartUuid}")
    public BaseResponseEntity<GetCartAndProductResVo> getCartItem(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 단건 조회에 성공하였습니다.",
                cartService.getCartItem(GetMyCartUuidReqDto.of(authentication.getName(), cartUuid)).toVo());
    }

    /**
     * 6. 장바구니 항목 체크 여부 조회
     *
     * @param authentication 멤버 UUID
     * @param cartUuid       카트 UUID
     * @return 장바구니 체크 여부 조회 결과
     */
    @Operation(summary = "장바구니 항목 체크 여부 조회", tags = {"cart"})
    @GetMapping("/{cartUuid}/get-selected")
    public BaseResponseEntity<GetCartSelectResVo> getItemSelect(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 체크 여부 조회에 성공하였습니다.",
                cartService.getItemSelect(GetMyCartUuidReqDto.of(authentication.getName(), cartUuid)).toVo());
    }

    /**
     * 7. 장바구니에서 장바구니 유형별로 상품 UUID 리스트 조회 (일반/예약)
     *
     * @param authentication 멤버 UUID
     * @param cartType       카트 타입
     * @return 유형별 장바구니 상품 리스트 조회 결과
     */
    // cartType : general, reservation
    @Operation(
            summary = "장바구니에서 장바구니 유형별로 상품 UUID 리스트 조회 (일반/예약)",
            description = "cartType - 일반 : general / 예약 : reservation",
            tags = {"cart"},
            hidden = true
    )
    @GetMapping("/product/{cartType}")
    public BaseResponseEntity<List<GetProductUuidResVo>> getProductUuid(
            Authentication authentication,
            @PathVariable String cartType
    ) {
        return new BaseResponseEntity<>(
                "장바구니에서 장바구니 유형별로 Product UUID 리스트 조회 성공",
                cartService.getProductUuidList(GetMyCartTypeReqDto.of(authentication.getName(), cartType))
                        .stream().map(GetProductUuidResDto::toVo).toList());
    }

    /**
     * 8. 장바구니에서 항목 수량 감소
     *
     * @param authentication 멤버 UUID
     * @param cartUuid       카트 UUID
     * @return 장바구니 항목 수량 감소 결과
     */
    @Operation(summary = "장바구니에서 항목 수량 감소", tags = {"cart"}, hidden = true)
    @PutMapping("/{cartUuid}/item-decrease")
    public BaseResponseEntity<Void> decreaseCartQuantity(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.decreaseCartQuantity(GetMyCartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 1개 감소");
    }

    /**
     * 9. 장바구니에서 항목 수량 증가
     *
     * @param authentication 멤버 UUID
     * @param cartUuid       카트 UUID
     * @return 장바구니 항목 수량 증가 결과
     */
    @Operation(summary = "장바구니에서 항목 수량 증가", tags = {"cart"}, hidden = true)
    @PutMapping("/{cartUuid}/item-increase")
    public BaseResponseEntity<Void> increaseCartQuantity(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.increaseCartQuantity(GetMyCartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 1개 증가");
    }

    /**
     * 10. 장바구니 유형 별로 총 항목 갯수를 조회
     *
     * @param authentication 멤버 UUID
     * @param cartType       카트 타입
     * @return 장바구니 유형별 항목 갯수 조회 결과
     */
    @Operation(summary = "장바구니 유형 별로 총 항목 갯수를 조회", tags = {"cart"})
    @GetMapping("/count/{cartType}")
    public BaseResponseEntity<GetTotalCartCountResVo> countTotalCart(
            Authentication authentication,
            @PathVariable String cartType
    ) {
        return new BaseResponseEntity<>(
                "장바구니 유형 별로 총 항목 갯수 조회 성공",
                cartService.countTotalCart(GetMyCartTypeReqDto.of(authentication.getName(), cartType)).toVo());
    }

    /**
     * 11. ProductUuid 로 cart 조회
     *
     * @param authentication 멤버 UUID
     * @param productUuid    상품 UUID
     * @return ProductUUID -> Cart 조회 결과
     */
    @Operation(summary = "ProductUuid 로 cart 조회", tags = {"cart"}, hidden = true)
    @GetMapping("/by-product/{productUuid}")
    public List<GetQuantityAndSelectedVo> getCartByProductUuid(
            Authentication authentication,
            @PathVariable String productUuid
    ) {
        return cartService.getCartByProductUuid(
                ProductUuidReqDto.of(authentication.getName(), productUuid)
        ).stream().map(GetQuantityAndSelectedDto::toVo).toList();
    }

    /**
     * 12. memberUuid 로 cartUuid list 조회
     *
     * @param authentication 멤버 UUID
     * @return memberUUID -> cartUUID 조회 결과
     */
    @Operation(
            summary = "memberUuid 로 장바구니 유형별 cartUuid list 조회",
            description = "cartType - 없으면 전체 조회 / 일반 : general / 예약 : reservation",
            tags = {"cart"}
    )
    @GetMapping("/uuid-list")
    public BaseResponseEntity<List<GetAllMyCartUuidVo>> getMyCartUuids(
            Authentication authentication,
            @RequestParam(required = false) String cartType
    ) {
        return new BaseResponseEntity<>(
                "memberUuid 로 cartUuid list 조회에 성공하였습니다.",
                cartService.getMyCartUuids(com.team114.starbucks.domain.cart.dto.in.GetMyCartTypeReqDto.of(authentication.getName(), cartType))
                        .stream().map(GetAllMyCartUuidDto::toVo).toList());
    }

    /**
     * 13. 장바구니 항목 체크여부 변경
     *
     * @param authentication 멤버 UUID
     * @param cartUuid       카트 UUID
     * @return 장바구니 항목 체크여부 결과
     */
    @Operation(summary = "장바구니 항목 체크여부 변경", tags = {"cart"})
    @PutMapping("/{cartUuid}/toggle-selection")
    public BaseResponseEntity<Void> toggleCartSelection(
            Authentication authentication,
            @PathVariable String cartUuid
    ) {
        cartService.toggleCartSelection(GetMyCartUuidReqDto.of(authentication.getName(), cartUuid));
        return new BaseResponseEntity<>("장바구니 항목 체크여부 변경에 성공하였습니다.");
    }

    /**
     * 14. 장바구니 항목 전체 선택 및 전체 해제
     *
     * @param authentication 멤버 UUID
     * @return 장바구니 항목 전체 선택/해제 결과
     */
    @Operation(summary = "장바구니 항목 전체 선택 및 전체 해제", tags = {"cart"})
    @PutMapping("/all/toggle-selection")
    public BaseResponseEntity<List<GetAllMyCartUuidVo>> toggleAllCartSelection(
            Authentication authentication
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 전체 선택 및 전체 해제에 성공하였습니다.",
                cartService.toggleAllCartSelection(authentication.getName()).stream().map(GetAllMyCartUuidDto::toVo).toList()
        );
    }

    /**
     * 15. 장바구니 항목 갯수 정보 변경
     *
     * @param authentication    멤버 UUID
     * @param cartUuid          카트 UUID
     * @param cartQuantityReqVo 카트 수량
     * @return 장바구니 항목 갯수 정보 변경 결과
     */
    @Operation(summary = "장바구니 항목 갯수 정보 변경", tags = {"cart"})
    @PutMapping("/{cartUuid}/quantity-change")
    public BaseResponseEntity<Void> changeCartQuantity(
            Authentication authentication,
            @PathVariable String cartUuid,
            @RequestBody CartQuantityReqVo cartQuantityReqVo
    ) {
        cartService.changeCartQuantity(GetMyCartQuantityReqDto.of(authentication.getName(), cartUuid, cartQuantityReqVo));
        return new BaseResponseEntity<>("장바구니에서 해당 장바구니 항목 수량 변경에 성공하였습니다.");
    }

    /**
     * 16. 장바구니 전체 삭제
     *
     * @param authentication 멤버 UUID
     * @param cartType       카트 타입
     * @return 장바구니 전체 삭제 결과
     */
    @Operation(
            summary = "내 장바구니 유형별 항목 전체 삭제",
            description = "cartType - 일반 : general / 예약 : reservation",
            tags = {"cart"}
    )
    @DeleteMapping("/{cartType}/all")
    public BaseResponseEntity<Void> deleteAllCartItems(
            Authentication authentication,
            @PathVariable String cartType
    ) {
        cartService.deleteAllCartItems(com.team114.starbucks.domain.cart.dto.in.GetMyCartTypeReqDto.of(authentication.getName(), cartType));
        return new BaseResponseEntity<>("내 장바구니 유형별 항목 전체 삭제에 성공하였습니다.");
    }

}