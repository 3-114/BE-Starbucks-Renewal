package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetCartSelectResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCartSelectResDto {

    private Boolean selected;

    @Builder
    public GetCartSelectResDto(Boolean selected) {
        this.selected = selected;
    }

    public static GetCartSelectResDto from(Cart cart) {
        return GetCartSelectResDto.builder()
                .selected(cart.getSelected())
                .build();
    }

    public GetCartSelectResVo toVo() {
        return GetCartSelectResVo.builder()
                .selected(selected)
                .build();
    }

}