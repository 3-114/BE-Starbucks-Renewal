package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetQuantityAndSelectedVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetQuantityAndSelectedDto {

    private Long quantity;
    private Boolean selected;

    @Builder
    public GetQuantityAndSelectedDto(Long quantity, Boolean selected) {
        this.quantity = quantity;
        this.selected = selected;
    }

    public GetQuantityAndSelectedVo toVo() {
        return GetQuantityAndSelectedVo.builder()
                .quantity(quantity)
                .selected(selected)
                .build();
    }

    public static GetQuantityAndSelectedDto from(Cart cart) {
        return GetQuantityAndSelectedDto.builder()
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .build();
    }

}