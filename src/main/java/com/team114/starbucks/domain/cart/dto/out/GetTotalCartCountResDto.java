package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.vo.out.GetTotalCartCountResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetTotalCartCountResDto {

    private Long totalCount;

    @Builder
    public GetTotalCartCountResDto(Long totalCount) {
        this.totalCount = totalCount;
    }

    public static GetTotalCartCountResDto from(Long totalCount) {
        return GetTotalCartCountResDto.builder()
                .totalCount(totalCount)
                .build();
    }

    public GetTotalCartCountResVo toVo() {
        return GetTotalCartCountResVo.builder()
                .totalCount(totalCount)
                .build();
    }

}