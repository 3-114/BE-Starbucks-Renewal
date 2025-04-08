package com.team114.starbucks.domain.cart.dto.in;

import com.team114.starbucks.domain.cart.vo.in.UpdateCartItemReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateCartItemReqDto {

    private Long quantity;
    private Boolean selected;

    @Builder
    public UpdateCartItemReqDto(Long quantity, Boolean selected) {
        this.quantity = quantity;
        this.selected = selected;
    }

    public static UpdateCartItemReqDto from(UpdateCartItemReqVo updateCartItemReqVo) {

        return UpdateCartItemReqDto.builder()
                .quantity(updateCartItemReqVo.getQuantity())
                .selected(updateCartItemReqVo.getSelected())
                .build();
    }
}
