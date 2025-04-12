package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.vo.out.CountTotalCartResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CountTotalCartResDto {

    private Long totalCount;

    @Builder
    public CountTotalCartResDto(Long totalCount) {
        this.totalCount = totalCount;
    }

    public static CountTotalCartResDto from(Long totalCount) {
        return CountTotalCartResDto.builder()
                .totalCount(totalCount)
                .build();
    }

    public CountTotalCartResVo toVo() {
        return CountTotalCartResVo.builder()
                .totalCount(totalCount)
                .build();
    }
}
