package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import com.team114.starbucks.domain.option.entity.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class AddCartItemReqDto {

    private String memberUuid;
    private String productUuid;
    private Long quantity;

    @Builder
    public AddCartItemReqDto(
            String memberUuid,
            String productUuid,
            Long quantity
    ) {
        this.memberUuid = memberUuid;
        this.productUuid = productUuid;
        this.quantity = quantity;
    }

    public static AddCartItemReqDto of(
            String memberUuid,
            AddCartItemReqVo addCartItemReqVo
    ) {
        return AddCartItemReqDto.builder()
                .memberUuid(memberUuid)
                .productUuid(addCartItemReqVo.getProductUuid())
                .quantity(addCartItemReqVo.getQuantity())
                .build();
    }

    public Cart toEntity(Option option) {

        return Cart.builder()
                .cartUuid(UUID.randomUUID().toString())
                .memberUuid(memberUuid)
                .optionId(option.getOptionId())
                .productUuid(productUuid)
                .quantity(quantity)
                .selected(true)
                .valid(true)
                .cartType(CartType.GENERAL)
                .build();
    }
}
