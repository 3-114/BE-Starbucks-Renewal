package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetAllMyCartUuidVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllMyCartUuidDto {

    private String cartUuid;

    @Builder
    public GetAllMyCartUuidDto(String cartUuid) {
        this.cartUuid = cartUuid;
    }

    public static GetAllMyCartUuidDto from(Cart cart) {
        return GetAllMyCartUuidDto.builder()
                .cartUuid(cart.getCartUuid())
                .build();
    }

    public GetAllMyCartUuidVo toVo() {
        return GetAllMyCartUuidVo.builder()
                .cartUuid(cartUuid)
                .build();
    }

}