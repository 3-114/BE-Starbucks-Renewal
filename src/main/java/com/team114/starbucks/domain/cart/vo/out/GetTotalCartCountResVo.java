package com.team114.starbucks.domain.cart.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetTotalCartCountResVo {

    private Long totalCount;

    @Builder
    public GetTotalCartCountResVo(Long totalCount) {
        this.totalCount = totalCount;
    }

}