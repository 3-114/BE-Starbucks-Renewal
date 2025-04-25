package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMyCartUuidReqDto {

    private String memberUuid;
    private String cartUuid;

    @Builder
    public GetMyCartUuidReqDto(String memberUuid, String cartUuid) {
        this.memberUuid = memberUuid;
        this.cartUuid = cartUuid;
    }

    public static GetMyCartUuidReqDto of(String memberUuid, String cartUuid) {
        return GetMyCartUuidReqDto.builder()
                .memberUuid(memberUuid)
                .cartUuid(cartUuid)
                .build();
    }

    public Cart decreaseQuantity(Cart cart) {
        return Cart.builder()
                .id(cart.getId())
                .cartUuid(cart.getCartUuid())
                .memberUuid(cart.getMemberUuid())
                .optionId(cart.getOptionId())
                .productUuid(cart.getProductUuid())
                .quantity(cart.getQuantity() - 1)
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .cartType(cart.getCartType())
                .build();
    }

    public Cart increaseQuantity(Cart cart) {
        return Cart.builder()
                .id(cart.getId())
                .cartUuid(cart.getCartUuid())
                .memberUuid(cart.getMemberUuid())
                .optionId(cart.getOptionId())
                .productUuid(cart.getProductUuid())
                .quantity(cart.getQuantity() + 1)
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .cartType(cart.getCartType())
                .build();
    }

    public Cart toggleSelection(Cart cart) {
        return Cart.builder()
                .id(cart.getId())
                .cartUuid(cart.getCartUuid())
                .memberUuid(cart.getMemberUuid())
                .optionId(cart.getOptionId())
                .productUuid(cart.getProductUuid())
                .quantity(cart.getQuantity())
                .selected(!cart.getSelected())
                .valid(cart.getValid())
                .cartType(cart.getCartType())
                .build();
    }

}