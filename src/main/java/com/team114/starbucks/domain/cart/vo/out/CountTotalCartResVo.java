package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CountTotalCartResVo {

    private Long totalCount;

    @Builder
    public CountTotalCartResVo(Long totalCount) {
        this.totalCount = totalCount;
    }
}
