package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCartItemResVo {

    private Long quantity;
    private Boolean selected;
    private Boolean valid;

    @Builder
    public GetCartItemResVo(
            Long quantity,
            Boolean selected,
            Boolean valid
    ) {
        this.quantity = quantity;
        this.selected = selected;
        this.valid = valid;
    }
}
