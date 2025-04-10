package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetItemSelectResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetItemSelectResDto {

    private Boolean selected;

    @Builder
    public GetItemSelectResDto(Boolean selected) {
        this.selected = selected;
    }

    public static GetItemSelectResDto from(Cart cart) {

        return GetItemSelectResDto.builder()
                .selected(cart.getSelected())
                .build();
    }

    public GetItemSelectResVo toVo() {

        return GetItemSelectResVo.builder()
                .selected(selected)
                .build();
    }
}
