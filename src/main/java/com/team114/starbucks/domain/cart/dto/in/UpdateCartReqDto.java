package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.in.UpdateCartReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateCartReqDto {

    private String memberUuid;
    private String cartUuid;
    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public UpdateCartReqDto(
            String memberUuid,
            String cartUuid,
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.memberUuid = memberUuid;
        this.cartUuid = cartUuid;
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }

    public static UpdateCartReqDto of(String memberUuid, UpdateCartReqVo updateCartReqVo) {
        return UpdateCartReqDto.builder()
                .memberUuid(memberUuid)
                .cartUuid(updateCartReqVo.getCartUuid())
                .quantity(updateCartReqVo.getQuantity())
                .selected(updateCartReqVo.getSelected())
                .valid(updateCartReqVo.getValid())
                .build();
    }

    public Cart toEntity(Cart cart) {
        return Cart.builder()
                .id(cart.getId())
                .cartUuid(cartUuid)
                .memberUuid(memberUuid)
                .optionId(cart.getOptionId())
                .productUuid(cart.getProductUuid())
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .cartType(cart.getCartType())
                .build();
    }

}