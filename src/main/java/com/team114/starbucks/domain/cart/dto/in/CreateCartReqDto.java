package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import com.team114.starbucks.domain.cart.vo.in.CreateCartReqVo;
import com.team114.starbucks.domain.option.entity.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateCartReqDto {

    private String memberUuid;
    private String productUuid;
    private Long quantity;

    @Builder
    public CreateCartReqDto(
            String memberUuid,
            String productUuid,
            Long quantity
    ) {
        this.memberUuid = memberUuid;
        this.productUuid = productUuid;
        this.quantity = quantity;
    }

    public static CreateCartReqDto of(String memberUuid, CreateCartReqVo createCartReqVo) {
        return CreateCartReqDto.builder()
                .memberUuid(memberUuid)
                .productUuid(createCartReqVo.getProductUuid())
                .quantity(createCartReqVo.getQuantity())
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