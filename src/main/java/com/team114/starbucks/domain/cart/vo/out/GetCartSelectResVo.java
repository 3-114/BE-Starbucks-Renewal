package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCartSelectResVo {

    private Boolean selected;

    @Builder
    public GetCartSelectResVo(Boolean selected) {
        this.selected = selected;
    }

}