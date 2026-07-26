package com.team114.starbucks.domain.membercoupon.dto.in;

import com.team114.starbucks.domain.membercoupon.vo.in.ConsumeCouponReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ConsumeCouponReqDto {

    private String couponUuid;

    @Builder
    public ConsumeCouponReqDto(String couponUuid) {
        this.couponUuid = couponUuid;
    }

    public static ConsumeCouponReqDto from(
            ConsumeCouponReqVo useCouponReqVo
    ) {
        return ConsumeCouponReqDto.builder()
                .couponUuid(useCouponReqVo.getCouponUuid())
                .build();
    }

}