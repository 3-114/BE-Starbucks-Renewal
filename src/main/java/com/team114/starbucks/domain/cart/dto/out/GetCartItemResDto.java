package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetCartItemResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCartItemResDto {

    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public GetCartItemResDto(
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }

    public static GetCartItemResDto from(Cart cart) {
        return GetCartItemResDto.builder()
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .valid(cart.getValid())
                .build();
    }

    public GetCartItemResVo toVo() {
        return GetCartItemResVo.builder()
                .quantity(quantity)
                .selected(selected)
                .valid(valid)
                .build();
    }

}