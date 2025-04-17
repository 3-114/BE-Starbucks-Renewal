package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetQuantityAndSelectedVo {

    private Long quantity;
    private Boolean selected;

    @Builder
    public GetQuantityAndSelectedVo(Long quantity, Boolean selected) {
        this.quantity = quantity;
        this.selected = selected;
    }
}
