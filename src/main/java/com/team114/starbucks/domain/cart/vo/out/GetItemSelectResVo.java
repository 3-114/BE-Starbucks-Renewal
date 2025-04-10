package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetItemSelectResVo {

    private Boolean selected;

    @Builder
    public GetItemSelectResVo(Boolean selected) {
        this.selected = selected;
    }
}
