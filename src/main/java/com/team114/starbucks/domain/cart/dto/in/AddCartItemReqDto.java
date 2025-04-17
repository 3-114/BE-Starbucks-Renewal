package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddCartItemReqDto {

    private String memberUuid;
    private String productUuid;
    private Long optionId;
    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public AddCartItemReqDto(
            String memberUuid,
            String productUuid,
            Long optionId,
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.memberUuid = memberUuid;
        this.productUuid = productUuid;
        this.optionId = optionId;
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }

    public static AddCartItemReqDto of(
            String memberUuid,
            AddCartItemReqVo addCartItemReqVo
    ) {
        return AddCartItemReqDto.builder()
                .memberUuid(memberUuid)
                .productUuid(addCartItemReqVo.getProductUuid())
                .optionId(addCartItemReqVo.getOptionId())
                .quantity(addCartItemReqVo.getQuantity())
                .selected(addCartItemReqVo.getSelected())
                .valid(addCartItemReqVo.getValid())
                .build();
    }

    public Cart toEntity(String cartUuid) {

        return Cart.builder()
                .cartUuid(cartUuid)
                .memberUuid(memberUuid)
                .optionId(optionId)
                .productUuid(productUuid)
                .quantity(quantity)
                .selected(selected)
                .valid(valid)
                .cartType(CartType.GENERAL)
                .build();
    }
}
