package com.team114.starbucks.domain.cart.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.cart.application.CartService;
import com.team114.starbucks.domain.cart.dto.in.AddCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.in.UpdateCartItemReqDto;
import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetProductUuidResDto;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartItemReqVo;
import com.team114.starbucks.domain.cart.vo.out.GetAllCartItemsResVo;
import com.team114.starbucks.domain.cart.vo.out.GetCartItemResVo;
import com.team114.starbucks.domain.cart.vo.out.GetItemSelectResVo;
import com.team114.starbucks.domain.cart.vo.out.GetProductUuidResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public BaseResponseEntity<Void> addCartItem(
            @RequestHeader("Member-Uuid") String memberUuid,
            @RequestBody AddCartItemReqVo addCartItemReqVo
    ) {
        cartService.addCartItem(AddCartItemReqDto.of(memberUuid, addCartItemReqVo));
        return new BaseResponseEntity<>("장바구니에 추가되었습니다.", null);
    }

    @GetMapping
    public BaseResponseEntity<List<GetAllCartItemsResVo>> getAllCartItems(
            @RequestHeader("X-Member-UUID") String memberUuid            // member UUID
    ) {
        List<GetAllCartItemsResVo> result = cartService.findAllCartItems(memberUuid)
                .stream().map(GetAllCartItemsResDto::toVo).toList();
        return new BaseResponseEntity<>("장바구니 전체 목록 조회에 성공하였습니다.", result);
    }

    @PutMapping("/{cartUuid}")
    public BaseResponseEntity<Void> updateCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PathVariable String cartUuid,
            @RequestBody UpdateCartItemReqVo updateCartItemReqVo          // 수량, 선택 여부
    ) {
        cartService.updateCartItem(memberUuid, cartUuid, UpdateCartItemReqDto.from(updateCartItemReqVo));
        return new BaseResponseEntity<>("장바구니 항목 정보 변경에 성공하였습니다.", null);
    }

    @DeleteMapping("/{cartUuid}")
    public BaseResponseEntity<Void> deleteCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PathVariable String cartUuid
    ) {
        cartService.deleteCartItem(memberUuid, cartUuid);
        return new BaseResponseEntity<>("장바구니 항목 삭제에 성공하였습니다.", null);
    }

    @GetMapping("/{cartUuid}")
    public BaseResponseEntity<GetCartItemResVo> getCartItem(
            @RequestHeader("X-Member-UUID") String memberUuid,            // member UUID
            @PathVariable String cartUuid
    ) {
        GetCartItemResVo result = cartService.getCartItem(memberUuid, cartUuid).toVo();
        return new BaseResponseEntity<>("장바구니 항목 단건 조회에 성공하였습니다.", result);
    }

    @GetMapping("/{cartUuid}/get-selected")
    public BaseResponseEntity<GetItemSelectResVo> getItemSelect(
            @RequestHeader("X-Member-UUID") String memberUuid,
            @PathVariable String cartUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니 항목 체크 여부 조회에 성공하였습니다.",
                cartService.getItemSelect(memberUuid, cartUuid).toVo()
        );
    }

    @GetMapping("/product")
    public BaseResponseEntity<List<GetProductUuidResVo>> getProductUuid(
            @RequestHeader("Member-Uuid") String memberUuid
    ) {
        return new BaseResponseEntity<>(
                "장바구니에서 Product UUID 리스트 조회 성공",
                cartService.getProductUuidList(memberUuid).stream().map(GetProductUuidResDto::toVo).toList()
        );
    }
}
