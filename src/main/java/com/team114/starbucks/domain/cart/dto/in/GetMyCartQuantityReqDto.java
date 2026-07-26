package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.in.CartQuantityReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMyCartQuantityReqDto {

    private String memberUuid;
    private String cartUuid;
    private Long quantity;

    @Builder
    public GetMyCartQuantityReqDto(String memberUuid, String cartUuid, Long quantity) {
        this.memberUuid = memberUuid;
        this.cartUuid = cartUuid;
        this.quantity = quantity;
    }

    public static GetMyCartQuantityReqDto of(String memberUuid, String cartUuid, CartQuantityReqVo cartQuantityReqVo) {
        return GetMyCartQuantityReqDto.builder()
                .memberUuid(memberUuid)
                .cartUuid(cartUuid)
                .quantity(cartQuantityReqVo.getQuantity())
                .build();
    }

    public Cart changeQuantity(Cart cart) {
        return Cart.builder()
                .id(cart.getId())
                .cartUuid(cart.getCartUuid())
                .memberUuid(cart.getMemberUuid())
                .optionId(cart.getOptionId())
                .productUuid(cart.getProductUuid())
                .quantity(quantity)
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .cartType(cart.getCartType())
                .build();
    }

}