package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.in.AddCartItemReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddCartItemReqDto {

    private Long quantity;
    private Boolean selected;

    @Builder
    public AddCartItemReqDto(Long quantity, Boolean selected) {
        this.quantity = quantity;
        this.selected = selected;
    }

    // dto <- vo
    public static AddCartItemReqDto from(AddCartItemReqVo addCartItemReqVo) {

        return AddCartItemReqDto.builder()
                .quantity(addCartItemReqVo.getQuantity())
                .selected(addCartItemReqVo.getSelected())
                .build();
    }
}
