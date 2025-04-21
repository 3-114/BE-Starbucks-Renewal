package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.MyCartUuidVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyCartUuidDto {

    private String cartUuid;

    @Builder
    public MyCartUuidDto(String cartUuid) {
        this.cartUuid = cartUuid;
    }

    public static MyCartUuidDto from(Cart cart) {
        return MyCartUuidDto.builder()
                .cartUuid(cart.getCartUuid())
                .build();
    }

    public MyCartUuidVo toVo() {
        return MyCartUuidVo.builder()
                .cartUuid(cartUuid)
                .build();
    }
}
